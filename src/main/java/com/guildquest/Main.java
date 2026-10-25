package com.guildquest;

import com.guildquest.model.Adventurer;
import com.guildquest.service.AdventurerService;

public class Main {
    public static void main(String[] args){

        System.out.println("Hello");
        AdventurerService service = new AdventurerService();

        Adventurer max = new Adventurer(1, "Max");
        Adventurer aria = new Adventurer(2, "Aria");

        service.registerAdventurer(max);
        service.registerAdventurer(aria);

        Adventurer result = service.findAdventurerById(1);
        System.out.println("hi");

        System.out.println(result.getName()); // Max

    }
}
