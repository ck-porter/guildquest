package com.guildquest.service;

import com.guildquest.model.Adventurer;
import com.guildquest.repository.AdventurerRepository;

public class AdventurerService {

    private final AdventurerRepository repository;

    public AdventurerService(AdventurerRepository repository){

        this.repository = repository;
    }

    public void registerAdventurer(Adventurer adventurer){
        if(adventurer == null){
            throw new IllegalArgumentException("Adventurer cannot be null");
        }

        if(repository.existsById(adventurer.getId())){
            throw new IllegalArgumentException("Adventurer ID must be unique.");
        }

        repository.save(adventurer);
    }

    public Adventurer findAdventurerById(int id){
        return repository.findById(id);
    }
}
