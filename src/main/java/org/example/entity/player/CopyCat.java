package org.example.entity.player;

import org.example.enums.PlayerAction;

public class CopyCat implements Player {
    private int score = 0;
    private PlayerAction lastAction = PlayerAction.CHEAT;

    @Override
    public PlayerAction play() {
        return lastAction;
    }

    @Override
    public void updateScore(int score, PlayerAction opponentAction) {
        lastAction = opponentAction;
        this.score += score;
    }

    @Override
    public int result() {
        return this.score;
    }
}
