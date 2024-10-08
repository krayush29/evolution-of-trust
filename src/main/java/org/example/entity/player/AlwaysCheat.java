package org.example.entity.player;

import org.example.enums.PlayerAction;

public class AlwaysCheat implements Player {
    private int score = 0;

    @Override
    public PlayerAction play() {
        return PlayerAction.CHEAT;
    }

    @Override
    public void updateScore(int score) {
        this.score += score;
    }

    @Override
    public int result() {
        return this.score;
    }
}
