package org.example.entity;

import org.junit.jupiter.api.Test;

import static org.example.enums.PlayerType.ALWAYS_CHEAT;
import static org.example.enums.PlayerType.ALWAYS_COOPERATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EotMachineTest {

    @Test
    void testExceptionPlayerCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new EotMachine(null, null));

        assertThrows(IllegalArgumentException.class, () -> new EotMachine(new Player(ALWAYS_COOPERATE), null));

        assertThrows(IllegalArgumentException.class, () -> new EotMachine(null, new Player(ALWAYS_COOPERATE)));
    }

    @Test
    void testBothPlayersCheat() {
        Player firstPlayer = new Player(ALWAYS_CHEAT);
        Player secondPlayer = new Player(ALWAYS_CHEAT);
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(1);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testPlayer1CheatsPlayer2Cooperates() {
        Player firstPlayer = new Player(ALWAYS_CHEAT);
        Player secondPlayer = new Player(ALWAYS_COOPERATE);
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(1);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    void testPlayer1CooperatesPlayer2Cheats() {
        Player firstPlayer = new Player(ALWAYS_COOPERATE);
        Player secondPlayer = new Player(ALWAYS_CHEAT);
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(1);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }

    @Test
    void testBothPlayersCooperate() {
        Player firstPlayer = new Player(ALWAYS_COOPERATE);
        Player secondPlayer = new Player(ALWAYS_COOPERATE);
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(1);

        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
    void testBothPlayersCheatForFiveRounds() {
        Player firstPlayer = new Player(ALWAYS_CHEAT);
        Player secondPlayer = new Player(ALWAYS_CHEAT);
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(5);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testPlayer1CheatsPlayer2CooperatesForFiveRounds() {
        Player firstPlayer = new Player(ALWAYS_CHEAT);
        Player secondPlayer = new Player(ALWAYS_COOPERATE);
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(5);

        assertEquals(15, firstPlayer.getScore());
        assertEquals(-5, secondPlayer.getScore());
    }

    @Test
    void testPlayer1CooperatesPlayer2CheatsForFiveRounds() {
        Player firstPlayer = new Player(ALWAYS_COOPERATE);
        Player secondPlayer = new Player(ALWAYS_CHEAT);
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);
        eotMachine.play(5);

        assertEquals(-5, firstPlayer.getScore());
        assertEquals(15, secondPlayer.getScore());
    }

    @Test
    void testBothPlayersCooperateForFiveRounds() {
        Player firstPlayer = new Player(ALWAYS_COOPERATE);
        Player secondPlayer = new Player(ALWAYS_COOPERATE);
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);
        eotMachine.play(5);

        assertEquals(10, firstPlayer.getScore());
        assertEquals(10, secondPlayer.getScore());
    }
}