package org.example.entity;

import org.example.entity.player.AlwaysCheat;
import org.example.entity.player.AlwaysCooperate;
import org.example.entity.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EotMachineTest {

    @Test
    void testExceptionPlayerCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new EotMachine(null, null));

        assertThrows(IllegalArgumentException.class, () -> new EotMachine(new AlwaysCooperate(), null));

        assertThrows(IllegalArgumentException.class, () -> new EotMachine(null, new AlwaysCooperate()));
    }

    @Test
    void testBothPlayersCheat() {
        Player firstPlayer = new AlwaysCheat();
        Player secondPlayer = new AlwaysCheat();
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(1);

        assertEquals(0, firstPlayer.result());
        assertEquals(0, secondPlayer.result());
    }

    @Test
    void testPlayer1CheatsPlayer2Cooperates() {
        Player firstPlayer = new AlwaysCheat();
        Player secondPlayer = new AlwaysCooperate();
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(1);

        assertEquals(3, firstPlayer.result());
        assertEquals(-1, secondPlayer.result());
    }

    @Test
    void testPlayer1CooperatesPlayer2Cheats() {
        Player firstPlayer = new AlwaysCooperate();
        Player secondPlayer = new AlwaysCheat();
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(1);

        assertEquals(-1, firstPlayer.result());
        assertEquals(3, secondPlayer.result());
    }

    @Test
    void testBothPlayersCooperate() {
        Player firstPlayer = new AlwaysCooperate();
        Player secondPlayer = new AlwaysCooperate();
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(1);

        assertEquals(2, firstPlayer.result());
        assertEquals(2, secondPlayer.result());
    }

    @Test
    void testBothPlayersCheatForFiveRounds() {
        Player firstPlayer = new AlwaysCheat();
        Player secondPlayer = new AlwaysCheat();
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(5);

        assertEquals(0, firstPlayer.result());
        assertEquals(0, secondPlayer.result());
    }

    @Test
    void testPlayer1CheatsPlayer2CooperatesForFiveRounds() {
        Player firstPlayer = new AlwaysCheat();
        Player secondPlayer = new AlwaysCooperate();
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);

        eotMachine.play(5);

        assertEquals(15, firstPlayer.result());
        assertEquals(-5, secondPlayer.result());
    }

    @Test
    void testPlayer1CooperatesPlayer2CheatsForFiveRounds() {
        Player firstPlayer = new AlwaysCooperate();
        Player secondPlayer = new AlwaysCheat();
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);
        eotMachine.play(5);

        assertEquals(-5, firstPlayer.result());
        assertEquals(15, secondPlayer.result());
    }

    @Test
    void testBothPlayersCooperateForFiveRounds() {
        Player firstPlayer = new AlwaysCooperate();
        Player secondPlayer = new AlwaysCooperate();
        EotMachine eotMachine = new EotMachine(firstPlayer, secondPlayer);
        eotMachine.play(5);

        assertEquals(10, firstPlayer.result());
        assertEquals(10, secondPlayer.result());
    }
}