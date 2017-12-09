package com.ingenious.algorithms.bots.algorithms.Greedy;
import com.ingenious.algorithms.bots.BotAlgorithm;
import com.ingenious.algorithms.calculators.ScoreCalculator;
import com.ingenious.algorithms.generators.AvailableMovesGenerator;
import com.ingenious.engine.Game;
import com.ingenious.models.move.Move;
import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;
import java.util.ArrayList;

/**
 * Created by danig on 12/3/2017.
 */
public class GreedyAlgorithm {

    private Game game;

    public GreedyAlgorithm() {

    }

    public Game getGame(){
        if (this.game == null)
            this.game = GameServiceProvider.game().getClone();
        return this.game;
    }

    @Override
    public Move generateMove(){
        AvailableMovesGenerator factory = new AvailableMovesGenerator(this.getGame());
        ArrayList<Move> moves_available = factory.generate();
        ScoreCalculator calculator = new ScoreCalculator();
        Move move = moves_available.get(0);
        Tile head = move.getPiece().getHead();
        Tile tail = move.getPiece().getTail();
        int high = calculator.getScoreStreak(head, game.getBoard(), move.getBoardNode(), move.getBoardNode2()) + calculator.getScoreStreak(tail, game.getBoard(), move.getBoardNode2(), move.getBoardNode());
        for(int i=0; i<moves_available.size(); i++){
            Move current = moves_available.get(i);
            Tile headC = current.getPiece().getHead();
            Tile tailC = current.getPiece().getTail();
            int score = calculator.getScoreStreak(head, game.getBoard(), current.getBoardNode(),current.getBoardNode2())+ calculator.getScoreStreak(head, game.getBoard(), current.getBoardNode2(),current.getBoardNode());
            if(score>high){
                high = score;
                move = moves_available.get(i);
            }
        }
        return move;

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
