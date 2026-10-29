package com.guildquest.model;

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
            throw new IllegalArgumentException("Player ID must be greater than 0.");
        }

        this.id = id;

        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        this.name = name;
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
        return maxHealth;
    }

    public void addGold(int amount){
        if(amount < 0){
            throw new IllegalArgumentException("The amount of gold cannot be a negative number");
        }else if(amount > Integer.MAX_VALUE - this.gold){
            throw new IllegalArgumentException("You cannot have more than Int max gold");
        } else {
            this.gold += amount;
        }
    }

    public void takeDamage(int damage){
        if(damage < 0) {
            throw new IllegalArgumentException("The amount of damage cannot be a negative number");
        }

        this.health = Math.max(this.health - damage, 0);
    }

    public void heal(int amount){
        if(amount < 0){
            throw new IllegalArgumentException("The amount of healing cannot be a negative number");
        }

        this.health = Math.min(this.health + amount, this.maxHealth);
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
