package org.example.entity.player;

import org.example.enums.PlayerAction;

public class AlwaysCooperate implements Player {
    private int score = 0;

    @Override
    public PlayerAction play() {
        return PlayerAction.COOPERATE;
    }

    @Override
    public void updateScore(int score, PlayerAction opponentAction) {
        this.score += score;
    }

    @Override
    public int result() {
        return this.score;
    }
}
