package org.example.entity;

import org.example.enums.PlayerAction;
import org.example.enums.PlayerType;

public class Player {
    private final PlayerType playerType;
    private int score = 0;

    public Player(PlayerType playerType) {
        this.playerType = playerType;
    }

    public PlayerAction play() {
        if (this.playerType == PlayerType.ALWAYS_CHEAT) {
            return PlayerAction.CHEAT;
        } else {
            return PlayerAction.COOPERATE;
        }
    }

    public void updateScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }
}
