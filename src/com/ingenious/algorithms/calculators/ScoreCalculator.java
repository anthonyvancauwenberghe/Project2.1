package com.ingenious.algorithms.calculators;

import com.ingenious.events.impl.ScoreIsUpdatedEvent;
import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.pieces.Piece;
import com.ingenious.models.score.Score;
import com.ingenious.models.tiles.Tile;

public class ScoreCalculator {

    public static int getScoreStreak(Board board, BoardNode boardNode_1, BoardNode boardNode_2) {
        int x = boardNode_1.getX();
        int y = boardNode_1.getY();
        int l = 1;
        int addedScore = 0;
        Tile tile = boardNode_1.getTile();

        while (board.getNode(x, y - l) != null && board.getNode(x, y - l) != boardNode_2 && tile.equals(board.getNode(x, y - l).getTile())) {
            addedScore++;
            l++;
        }
        l = 1;
        while (board.getNode(x, y + l) != null && board.getNode(x, y + l) != boardNode_2 && tile.equals(board.getNode(x, y + l).getTile())) {
            addedScore++;
            l++;
        }
        l = 1;
        while (board.getNode(x + l, y) != null && board.getNode(x + l, y) != boardNode_2 && tile.equals(board.getNode(x + l, y).getTile())) {
            addedScore++;
            l++;
        }
        l = 1;
        while (board.getNode(x - l, y) != null && board.getNode(x - l, y) != boardNode_2 && tile.equals(board.getNode(x - l, y).getTile())) {
            addedScore++;
            l++;
        }
        l = 1;
        while (board.getNode(x + l, y - l) != null && board.getNode(x + l, y - l) != boardNode_2 && tile.equals(board.getNode(x + l, y - l).getTile())) {
            addedScore++;
            l++;
        }
        l = 1;
        while (board.getNode(x - l, y + l) != null && board.getNode(x - l, y + l) != boardNode_2 && tile.equals(board.getNode(x - l, y + l).getTile())) {
            addedScore++;
            l++;
        }
        return addedScore;
    }

    public static int getScoreStreak(Tile tile, Board board, BoardNode boardNode_1, BoardNode boardNode_2) {
        int x = boardNode_1.getX();
        int y = boardNode_1.getY();
        int l = 1;
        int addedScore = 0;

        while (board.getNode(x, y - l) != null && board.getNode(x, y - l) != boardNode_2 && tile.equals(board.getNode(x, y - l).getTile())) {
            addedScore++;
            l++;
        }
        l = 1;
        while (board.getNode(x, y + l) != null && board.getNode(x, y + l) != boardNode_2 && tile.equals(board.getNode(x, y + l).getTile())) {
            addedScore++;
            l++;
        }
        l = 1;
        while (board.getNode(x + l, y) != null && board.getNode(x + l, y) != boardNode_2 && tile.equals(board.getNode(x + l, y).getTile())) {
            addedScore++;
            l++;
        }
        l = 1;
        while (board.getNode(x - l, y) != null && board.getNode(x - l, y) != boardNode_2 && tile.equals(board.getNode(x - l, y).getTile())) {
            addedScore++;
            l++;
        }
        l = 1;
        while (board.getNode(x + l, y - l) != null && board.getNode(x + l, y - l) != boardNode_2 && tile.equals(board.getNode(x + l, y - l).getTile())) {
            addedScore++;
            l++;
        }
        l = 1;
        while (board.getNode(x - l, y + l) != null && board.getNode(x - l, y + l) != boardNode_2 && tile.equals(board.getNode(x - l, y + l).getTile())) {
            addedScore++;
            l++;
        }
        return addedScore;
    }

    public static Score addScoreStreakToColor(Tile tile, Score oldScore, int addedScore) {
        int newScore = 0;
        if (tile.equals(Tile.green)) {
            newScore = addedScore + oldScore.getGreenScore();
            if (newScore > 18) {
                newScore = 18;
            }
            oldScore.setGreenScore(newScore);
        } else if (tile.equals(Tile.blue)) {
            newScore = addedScore + oldScore.getBlueScore();
            if (newScore > 18) {
                newScore = 18;
            }
            oldScore.setBlueScore(newScore);
        } else if (tile.equals(Tile.red)) {
            newScore = addedScore + oldScore.getRedScore();
            if (newScore > 18) {
                newScore = 18;
            }
            oldScore.setRedScore(newScore);
        } else if (tile.equals(Tile.yellow)) {
            newScore = addedScore + oldScore.getYellowScore();
            if (newScore > 18) {
                newScore = 18;
            }
            oldScore.setYellowScore(newScore);
        } else if (tile.equals(Tile.orange)) {
            newScore = addedScore + oldScore.getOrangeScore();
            if (newScore > 18) {
                newScore = 18;
            }
            oldScore.setOrangeScore(newScore);
        } else {
            newScore = addedScore + oldScore.getPurpleScore();
            if (newScore > 18) {
                newScore = 18;
            }
            oldScore.setPurpleScore(newScore);
        }

        new ScoreIsUpdatedEvent();
        return oldScore;
    }

    public static Score calculate(BoardNode boardNode_1, BoardNode boardNode_2, Board board, Score oldScore) {
        Tile tile = boardNode_1.getTile();
        int addedScore = getScoreStreak(board, boardNode_1, boardNode_2);
        return addScoreStreakToColor(tile, oldScore, addedScore);

    }
}
