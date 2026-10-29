package com.guildquest.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuildTest {

    private Adventurer adventurer;
    private Guild guild;

    @BeforeEach
    public void setUp(){
        adventurer = new Adventurer(1, "Max");
        guild = new Guild(1,"Test", 2);
        guild.addAdventurer(adventurer);
    }

    @Test
    public void addNewAdventurer(){
        Adventurer adventurer2 = new Adventurer(2, "Max2");
        guild.addAdventurer(adventurer2);
        assertEquals(2, guild.getMemberCount());
    }

    @Test
    public void addSameMemberTwiceThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> {
           guild.addAdventurer(adventurer);
        });
    }

    @Test
    public void addMemberToFullGuildThrowsException(){
        Adventurer adventurer2 = new Adventurer(2, "Mary");
        Adventurer adventurer3 = new Adventurer(3, "David");
        guild.addAdventurer(adventurer2);

        assertThrows(IllegalStateException.class, () -> {
            guild.addAdventurer(adventurer3);
        });
    }

    @Test
    public void removeMemberFreesUpSpot(){
        Guild guildOfOne = new Guild(2,"Guild for one", 1);

        Adventurer adventurer1 = new Adventurer(1, "Max");

        guildOfOne.addAdventurer(adventurer1);

        assertEquals(guildOfOne.getMaxMembers(), guildOfOne.getMemberCount());

        Adventurer adventurer2 = new Adventurer(2, "Mary");

        assertThrows(IllegalStateException.class, () -> {
            guildOfOne.addAdventurer(adventurer2);
        });

        guildOfOne.removeAdventurer(1);

        guildOfOne.addAdventurer(adventurer2);

        assertEquals(guildOfOne.getMaxMembers(), guildOfOne.getMemberCount());
    }

    @Test
    public void creatingGuildWithInvalidIdThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Guild guild = new Guild(-1, "Negative Guild", 2);
        });
    }

    @Test
    public void creatingAGuildNameWithNullEmptyOrWhiteSpaceOnlyThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Guild guild = new Guild(1, " ", 2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Guild guild = new Guild(1, "", 2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Guild guild = new Guild(1, null, 2);
        });
    }

    @Test
    public void creatingGuildWithInvalidMaxMembersThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Guild guild = new Guild(1, "Guild of none", -2);
        });
    }
}
