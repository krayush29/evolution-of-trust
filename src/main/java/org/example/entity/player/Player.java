package org.example.entity.player;

import org.example.enums.PlayerAction;

public interface Player {

    PlayerAction play();

    void updateScore(int score, PlayerAction opponentAction);

    int result();
}
