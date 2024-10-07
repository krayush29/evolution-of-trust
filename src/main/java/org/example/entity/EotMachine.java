package org.example.entity;

import org.example.enums.PlayerAction;
import org.example.enums.Result;

public class EotMachine {
    private final Player player1;
    private final Player player2;

    public EotMachine(Player player1, Player player2) {
        if (player1 == null || player2 == null) {
            throw new IllegalArgumentException("Players cannot be null");
        }

        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(int numberOfRounds) {
        PlayerAction player1Action = player1.play();
        PlayerAction player2Action = player2.play();

        for (int i = 0; i < numberOfRounds; i++) {
            if (player1Action == PlayerAction.COOPERATE) {
                player1.updateScore(Result.LOSE.getValue());
                player2.updateScore(Result.WIN.getValue());
            }

            if (player2Action == PlayerAction.COOPERATE) {
                player1.updateScore(Result.WIN.getValue());
                player2.updateScore(Result.LOSE.getValue());
            }
        }
    }
}
