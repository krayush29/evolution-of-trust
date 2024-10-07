package org.example.entity;

import org.example.enums.PlayerAction;
import org.junit.jupiter.api.Test;

import static org.example.enums.PlayerType.ALWAYS_CHEAT;
import static org.example.enums.PlayerType.ALWAYS_COOPERATE;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testAlwaysCheatingPlayerCheats() {
        Player alwaysCheatingPlayer = new Player(ALWAYS_CHEAT);

        assertEquals(PlayerAction.CHEAT, alwaysCheatingPlayer.play());
    }

    @Test
    void testAlwaysCooperatePlayerCheats() {
        Player firstAlwaysCooperatePlayer = new Player(ALWAYS_COOPERATE);

        assertEquals(PlayerAction.COOPERATE, firstAlwaysCooperatePlayer.play());
    }
}