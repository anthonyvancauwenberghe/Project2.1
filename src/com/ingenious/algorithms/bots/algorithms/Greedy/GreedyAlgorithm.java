package com.ingenious.algorithms.bots.algorithms.Greedy;

import com.ingenious.algorithms.bots.BotAlgorithm;
import com.ingenious.algorithms.calculators.ScoreCalculator;
import com.ingenious.algorithms.generators.AvailableMovesGenerator;
import com.ingenious.engine.Game;
import com.ingenious.models.board.Board;
import com.ingenious.models.board.BoardNode;
import com.ingenious.models.move.Move;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;

/**
 * Created by danig on 12/3/2017.
 */
public class GreedyAlgorithm extends BotAlgorithm {

    private Game game;

    public GreedyAlgorithm() {

    }

    public Game getGame(){
        if (this.game == null)
            this.game = GameServiceProvider.game();
        return this.game;
    }

    public Move generateMove(){
        //TODO RETURN GENERATED MOVE HERE!!
        AvailableMovesGenerator factory = new AvailableMovesGenerator(this.getGame());
        ScoreCalculator calculator = new ScoreCalculator();
        ArrayList<Move>  moves  = factory.generate();
        Board board = GameServiceProvider.board();
        int [] score = {0,0,0,0,0,0};
        Move [] move_c = new Move[6];
        for(int i =0; i<moves.size(); i++){
            Move move = moves.get(i);
            int indexHead = indexColor(move.getPiece().getHead());
            int indexTail = indexColor(move.getPiece().getTail());
            if(indexHead == indexTail){
                int scoreHead = calculator.getScoreStreak(board, move.getBoardNode(), move.getBoardNode2());
                int scoreTail = calculator.getScoreStreak(board, move.getBoardNode2(), move.getBoardNode());
                int sumScore = scoreHead+scoreTail;
                if(score[indexHead]<sumScore){
                    score[indexHead] = sumScore;
                    move_c[indexHead] = move;
                }

            }
            else{
                int scoreHead = calculator.getScoreStreak(board, move.getBoardNode(), move.getBoardNode2());
                int scoreTail = calculator.getScoreStreak(board, move.getBoardNode2(), move.getBoardNode());
                if(score[indexHead]<scoreHead){
                    score[indexHead] = scoreHead;
                    move_c[indexHead] = move;
                }
                if(score[indexTail]<scoreTail){
                    score[indexTail] = scoreTail;
                    move_c[indexTail] = move;
                }
            }
        }
        GameServiceProvider.players().getPlayer(1).getScoreArray();

        return move_c[0];
    }

    public int indexColor(Tile tile) {
        if (tile.isRed()) {
            return 0;
        }
        if (tile.isBlue()) {
            return 1;
        }
        if (tile.isGreen()) {
            return 2;
        }
        if (tile.isYellow()) {
            return 3;
        }
        if (tile.isOrange()) {
            return 4;
        } else {
            return 5;
        }
    }

}
