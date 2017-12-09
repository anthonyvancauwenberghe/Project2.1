package com.ingenious.engine.logic.impl;

import com.ingenious.engine.Game;
import com.ingenious.engine.logic.Logic;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.players.Player;

public class GameOverLogic extends Logic {

    public GameOverLogic(Game game) {
        super(game);
    }

    public boolean calculate() {
        return playerHasMaxScore() || noMovesLeft();
    }

    private boolean playerHasMaxScore() {
        for (int i = 0; i < 6; i++) {
            for (Player player : this.game.getPlayers()) {
                if (player.getScoreArray()[i] >= 18) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean noMovesLeft() {
        for (BoardNode boardNode : this.game.getBoard().getBoardNodes()) {
            if (boardNode.isAvailable()) {
                for (BoardNode neighbour : boardNode.getNeighbours()) {
                    if (neighbour.isAvailable())
                        return false;
                }
            }

        }
        return true;
    }
}
