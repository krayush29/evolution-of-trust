package org.example.entity.player;

import org.example.enums.PlayerAction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void testAlwaysCheatingPlayerCheats() {
        Player alwaysCheatingPlayer = new AlwaysCheat();

        assertEquals(PlayerAction.CHEAT, alwaysCheatingPlayer.play());
    }

    @Test
    void testAlwaysCooperatePlayerCheats() {
        Player AlwaysCooperatePlayer = new AlwaysCooperate();

        assertEquals(PlayerAction.COOPERATE, AlwaysCooperatePlayer.play());
    }

    @Test
    void testCopyCatPlayerCheatsFirst() {
        Player copycatPlayer = new CopyCat();

        assertEquals(PlayerAction.CHEAT, copycatPlayer.play());
    }
}