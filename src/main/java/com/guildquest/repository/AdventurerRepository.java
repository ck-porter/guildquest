package com.guildquest.repository;

import com.guildquest.model.Adventurer;

public interface AdventurerRepository {

     void save(Adventurer adventurer);

     Adventurer findById(int id);

     boolean existsById(int id);
}
