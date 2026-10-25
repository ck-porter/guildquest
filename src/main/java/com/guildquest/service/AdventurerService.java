package com.guildquest.service;

import com.guildquest.model.Adventurer;

import java.util.HashMap;
import java.util.Map;

public class AdventurerService {

    private Map<Integer, Adventurer> adventurers;

    public AdventurerService(){
        this.adventurers = new HashMap<>();
    }

    public void registerAdventurer(Adventurer adventurer){
        if(adventurer == null){
            throw new IllegalArgumentException("Adventurer cannot be null");
        }else if(adventurers.containsKey(adventurer.getId())){
            throw new IllegalArgumentException("Adventurer ID must be unique.");
        }

        adventurers.put(adventurer.getId(), adventurer);
    }

    public Adventurer findAdventurerById(int id){
        return adventurers.get(id);
    }
}
