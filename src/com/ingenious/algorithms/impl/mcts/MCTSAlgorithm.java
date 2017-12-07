package com.ingenious.algorithms.impl.mcts;

import com.ingenious.algorithms.Algorithm;
import com.ingenious.algorithms.impl.movegenerator.BaseMoveGenerator;
import com.ingenious.models.board.Board;
import com.ingenious.models.move.Move;
import com.ingenious.models.rack.Rack;
import com.ingenious.providers.impl.GameServiceProvider;

import java.util.ArrayList;

public class MCTSAlgorithm extends Algorithm {


    private Board board;
    private Rack rack;

    public MCTSAlgorithm() {
        this.initialize();
        System.out.println("initialized");
    }

    private void initialize() {
        this.board = GameServiceProvider.board().getClone();
        this.rack = GameServiceProvider.game().getCurrentPlayer().getRack().getClone();
    }

    public ArrayList<Move> generateBaseMoves() {
        BaseMoveGenerator generator = new BaseMoveGenerator(this.board, this.rack);
        return generator.generate();
    }

}
