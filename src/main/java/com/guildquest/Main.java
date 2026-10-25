package com.guildquest;

import com.guildquest.model.Adventurer;

public class Main {
    public static void main(String[] args){

        Adventurer adventurer = new Adventurer(12, "Max");
        adventurer.addGold(50);
        adventurer.takeDamage(30);
        adventurer.heal(10);

        System.out.println(adventurer);

        adventurer.takeDamage(200);
        System.out.println(adventurer);

        adventurer.heal(500);
        System.out.println(adventurer
        );

    }
}
