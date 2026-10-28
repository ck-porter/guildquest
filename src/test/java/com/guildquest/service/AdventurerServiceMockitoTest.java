package com.guildquest.service;

import com.guildquest.model.Adventurer;
import com.guildquest.repository.AdventurerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AdventurerServiceMockitoTest {

    private AdventurerRepository repository;
    private AdventurerService service;

    @BeforeEach
    public void setUp(){
        this.repository = mock(AdventurerRepository.class);
        this.service = new AdventurerService(repository);
    }

    @Test
    void registeringDuplicateIdThrowsException() {
        when(repository.existsById(1)).thenReturn(true);
        Adventurer adventurer = new Adventurer(1, "Max");

        assertThrows(IllegalArgumentException.class, () -> {
            service.registerAdventurer(adventurer);
        });

        verify(repository, never()).save(adventurer);
    }

    @Test
    void registerNewAdventurerSavesToRepository(){
        Adventurer adventurer = new Adventurer(1, "Max");
        when(repository.existsById(adventurer.getId())).thenReturn(false);
        service.registerAdventurer(adventurer);

        verify(repository).save(adventurer);
    }

    @Test
    void registeringNullAdventurerThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            service.registerAdventurer(null);
        });

        verify(repository, never()).save(any(Adventurer.class));
    }
}
