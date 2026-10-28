package com.guildquest.repository;

import com.guildquest.model.Adventurer;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAdventurerRepository implements AdventurerRepository{

    private Map<Integer, Adventurer> adventurers = new HashMap<>();

    public InMemoryAdventurerRepository(){};

    @Override
    public void save(Adventurer adventurer){
        adventurers.put(adventurer.getId(), adventurer);
    }

    @Override
    public Adventurer findById(int id){
        return adventurers.get(id);
    }

    @Override
    public boolean existsById(int id){
        return adventurers.containsKey(id);
    }
}
