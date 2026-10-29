package com.guildquest.model;

import java.util.HashMap;
import java.util.Map;

public class Guild {

    private int id;
    private String name;
    private int maxMembers;
    private final Map<Integer, Adventurer> currentMembers = new HashMap<>();

    public Guild(int id, String name, int maxMembers){
        if(id <= 0) {
            throw new IllegalArgumentException("Guild ID must be greater than 0.");
        }

        this.id = id;

        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Guild name cannot be null or blank.");
        }

        this.name = name;

        if(maxMembers <= 0){
            throw new IllegalArgumentException("A Guilds maximum members must be greater than 0.");
        }

        this.maxMembers = maxMembers;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getMaxMembers(){
        return maxMembers;
    }

    public void addAdventurer(Adventurer adventurer){
        if(adventurer == null){
            throw new IllegalArgumentException("Adventurer cannot be null");
        }

        if(currentMembers.containsKey(adventurer.getId())){
            throw new IllegalArgumentException("Adventurer cannot join the guild more than once.");
        }

        if(currentMembers.size() >= maxMembers){
            throw new IllegalStateException("Guild is full.");
        }

        currentMembers.put(adventurer.getId(), adventurer);
    }

    public void removeAdventurer(int id){
        if(!currentMembers.containsKey(id)){
            throw new IllegalArgumentException("Guild does not contain that id");
        }

        currentMembers.remove(id);
    }

    public int getMemberCount(){
        return currentMembers.size();
    }
}
