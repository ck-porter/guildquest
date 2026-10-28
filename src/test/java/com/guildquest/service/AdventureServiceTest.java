package com.guildquest.service;

import com.guildquest.model.Adventurer;
import com.guildquest.repository.InMemoryAdventurerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdventureServiceTest {

    private AdventurerService service;
    private Adventurer adventurer;
    private InMemoryAdventurerRepository repository;

    @BeforeEach
    public void setUp(){
        repository = new InMemoryAdventurerRepository();
        service = new AdventurerService(repository);
        adventurer = new Adventurer(1,"TestAdventurer");
        service.registerAdventurer(adventurer);
    }

    @Test
    public void registerNewAdventurer(){
        adventurer = new Adventurer(2,"TestAdventurer");
        service.registerAdventurer(adventurer);
        assertSame(adventurer, service.findAdventurerById(adventurer.getId()));
    }

    @Test
    public void findRegisteredAdventurerById(){
        assertEquals(adventurer, service.findAdventurerById(adventurer.getId()));
    }

    @Test
    public void findAnUnknownId(){
        assertNull(service.findAdventurerById(11));
    }

    @Test
    public void registerDuplicateIdThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            service.registerAdventurer(adventurer);
        });
    }

    @Test
    public void registerNullAdventurerException(){
        assertThrows(IllegalArgumentException.class, () -> {
            service.registerAdventurer(null);
        });
    }
}
