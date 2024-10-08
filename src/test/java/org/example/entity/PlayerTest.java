package org.example.entity;

import org.example.entity.player.AlwaysCheat;
import org.example.entity.player.AlwaysCooperate;
import org.example.entity.player.Player;
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
        Player firstAlwaysCooperatePlayer = new AlwaysCooperate();

        assertEquals(PlayerAction.COOPERATE, firstAlwaysCooperatePlayer.play());
    }
}