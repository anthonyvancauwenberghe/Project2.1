package com.ingenious.algorithms.impl;
import java.util.ArrayList;

import com.ingenious.models.board.Board;
import com.ingenious.models.board.Node;
import com.ingenious.models.score.Score;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;


public class State
{
    Board board;
    Score player1Score;
    Score player2Score;
    boolean player1sTurn;
    boolean bonusPlayTriggered = false;

    public State generateNewState(Node node1, Node node2, Tile tile1, Tile tile2)
    {
        State newState = new State();
        newState.player1sTurn = !player1sTurn;
        newState.board = this.board;
        newState.board.addTile(tile1, node1, false);
        newState.board.addTile(tile2, node2, false);

        Score scoreToUpdate, previousScore;
        if(player1sTurn)
        {
            scoreToUpdate = player1Score;
            previousScore = player1Score;
        }
        else
        {
            scoreToUpdate = player2Score;
            previousScore = player2Score;
        }

        scoreToUpdate = GameServiceProvider.game().calculate_score(node1, node2, newState.board, scoreToUpdate);
        scoreToUpdate = GameServiceProvider.game().calculate_score(node2, node1, newState.board, scoreToUpdate);

        int[] scoresPrevious = previousScore.getScores();
        int[] scoresUpdated = scoreToUpdate.getScores();
        for (int i = 0; i < 6; i++)
        {
            if (scoresPrevious[i] != scoresUpdated[i] && GameServiceProvider.game().bonus_play(scoresUpdated[i]))
            {
                bonusPlayTriggered = true;
                break;
            }
        }

        return newState;
    }

    public void createRootState()
    {
        board = GameServiceProvider.board().getClone();
        player1Score = new Score();
        player2Score = new Score();
        player1sTurn = true;
        bonusPlayTriggered = false;
    }
}
