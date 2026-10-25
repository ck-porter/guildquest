package com.guildquest.model;

import java.util.Formatter;

public class Adventurer {
    private int id;
    private String name;
    private int level;
    private int experience;
    private int gold;
    private int health;
    private int maxHealth;

    public Adventurer(int id, String name){
        if(id <= 0){
            throw new IllegalArgumentException("Play ID cannot be negative");
        }else{
            this.id = id;
        }

        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }else{
            this.name = name;
        }

        this.level = 1;
        this.experience = 0;
        this.gold = 0;
        this.health = 100;
        this.maxHealth = 100;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getLevel(){
        return level;
    }

    public int getExperience(){
        return experience;
    }

    public int getGold(){
        return gold;
    }

    public int getHealth(){
        return health;
    }

    public int getMaxHealth(){
        return id;
    }

    public int addGold(int amount){
        if(amount < 0){
            return 0;
        }else if(amount > Integer.MAX_VALUE - this.gold){
            return Integer.MAX_VALUE;
        } else {
            this.gold += amount;
            return gold;
        }
    }

    public int takeDamage(int damage){
        if(damage < 0){
            return 0;
        }else if(this.health - damage < 0 || this.health == 0){
            return 0;
        }else{
            return this.health - damage;
        }
    }

    public int heal(int amount){
        if(amount > 0){
            return 0;
        }else if(this.health + amount > maxHealth){
            return maxHealth;
        }else{
            return this.health + amount;
        }
    }

    @Override
    public String toString(){
        return String.format("""
                Adventurer: %s
                ID: %d
                Level: %d
                XP: %d
                Gold: %,d
                HP: %d/%d
                """.stripIndent(), name, id, level, experience, gold, health, maxHealth);
    }
}
