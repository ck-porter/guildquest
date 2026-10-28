package com.guildquest;

import com.guildquest.model.Adventurer;
import com.guildquest.repository.InMemoryAdventurerRepository;
import com.guildquest.service.AdventurerService;

public class Main {
    public static void main(String[] args){

        InMemoryAdventurerRepository repository = new InMemoryAdventurerRepository();
        AdventurerService service = new AdventurerService(repository);
        Adventurer adventurer = new Adventurer(1, "Max");

        service.registerAdventurer(adventurer);
        System.out.println(service.findAdventurerById(1));
    }
}
