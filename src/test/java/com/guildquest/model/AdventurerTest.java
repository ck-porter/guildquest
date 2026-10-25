package com.guildquest.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AdventurerTest {

    private Adventurer adventurer;

    @BeforeEach
    public void setUp(){
       adventurer = new Adventurer(1, "TestHero");
    }

    @Test
    public void damageReducesHealth() {
        adventurer.takeDamage(30);
        assertEquals(70, adventurer.getHealth());
    }

    @Test
    public void takeLethalDamageDoesNotReduceHealthBelowZero(){
        adventurer.takeDamage(150);
        assertEquals(0,adventurer.getHealth());
    }

    @Test
    public void healingRestoresHealth(){
        adventurer.takeDamage(30);
        adventurer.heal(10);
        assertEquals(80, adventurer.getHealth());
    }

    @Test
    public void healingDoesNotExceedMaxHealth(){
        adventurer.takeDamage(30);
        adventurer.heal(100);
        assertEquals(adventurer.getMaxHealth(), adventurer.getHealth());
    }

    @Test
    public void negativeDamageThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            adventurer.takeDamage(-10);
        });
    }

    @Test
    public void addingGoldIncreasesBalance(){
        adventurer.addGold(50);
        assertEquals(50, adventurer.getGold() );
    }

    @Test
    public void negativeGoldThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            adventurer.addGold(-10);
        });
    }

    @Test
    public void addingGoldBeyondIntMaxThrowsException(){
        adventurer.addGold(Integer.MAX_VALUE);

        assertThrows(IllegalArgumentException.class, ()->{
            adventurer.addGold(1);
        });

        assertEquals(Integer.MAX_VALUE, adventurer.getGold());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 90",
            "30, 70",
            "75, 25",
            "0, 100",
            "100, 0"
    })

    public void takeDamageProducesExpectedHealth(int damage, int expectedHealth){
        adventurer.takeDamage(damage);
        assertEquals(expectedHealth, adventurer.getHealth());
    }

}
