package com.guildquest.repository;

import com.guildquest.model.Adventurer;
import com.guildquest.service.AdventurerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryAdventurerRepositoryTest {

    private Adventurer adventurer;
    private InMemoryAdventurerRepository repository;

    @BeforeEach
    public void setUp(){
        this.repository = new InMemoryAdventurerRepository();
        this.adventurer = new Adventurer(1, "Max");
        repository.save(adventurer);
    }

    @Test
    public void saveAdventurer(){
        Adventurer test = new Adventurer(2, "Tester");
        repository.save(test);
        assertSame(test, repository.findById(test.getId()));
    }

    @Test
    public void findUnknownIdReturnsNull(){

        assertNull(repository.findById(13));
    }

    @Test
    public void existsByIdReturnsTrue(){

        assertTrue(repository.existsById(1));
    }

    @Test
    public void existsByIdReturnsFalse(){
        assertFalse(repository.existsById(99));
    }
}
