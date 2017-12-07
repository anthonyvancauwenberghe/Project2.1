package com.ingenious.algorithms.impl.evalutation;
import com.ingenious.algorithms.impl.State;
import com.ingenious.algorithms.impl.ModifiedBubblesort;
import com.ingenious.algorithms.impl.tree.Node;
import com.ingenious.algorithms.impl.tree.Tree;


public class ScoreEvalutationFunction
{
    public int evaluateScores(Tree tree, Node currentNode)
    {
        State currentNodeState = tree.getNodeState(currentNode);
        State parentNodeState = tree.getParentState(currentNode);

        int[] player1ScoreCurrent = currentNodeState.players.getPlayers().get(0).getScoreArray();
        int[] player2ScoreCurrent = currentNodeState.players.getPlayers().get(1).getScoreArray();

        int[] player1ScorePast = parentNodeState.players.getPlayers().get(0).getScoreArray();
        int[] player2ScorePast = parentNodeState.players.getPlayers().get(1).getScoreArray();


        int[] player1Diff = new int[6];
        int[] player2Diff = new int[6];

        for (int i = 0; i < 6; i++)
        {
            player1Diff[i]  = player1ScoreCurrent[i] - player1ScorePast[i];
            player2Diff[i] = player2ScoreCurrent[i] - player2ScorePast[i];
        }

        //multipliers
        //compare to opponent gain
        int maxWeight = 1;

        for (int j: player1ScorePast)
        {
            if(player1ScorePast[j] <= 8)
                player1Diff[j] *= maxWeight - player1ScorePast[j];
            else if (player1ScorePast[j] >= 9)
                player1Diff[j] *= maxWeight - (17 - player1ScorePast[j]);
            else  if (player1ScorePast[j] == 18)
                player1Diff[j] *= 0;
        }

        int totalGainP1 = 0;
        int totalGainP2 = 0;

        for(int i : player1Diff)
        {
            totalGainP1 += player1Diff[i];
        }
        for(int j : player2Diff)
        {
            totalGainP2 += player2Diff[j];
        }

        if(totalGainP1 > 0)
            return totalGainP1;
        else if (totalGainP2 > 0)
            return totalGainP2;
        else
            return 0;
    }

    private PointColor[] rankPointColors(int[] scoreArray) //TODO: make sure colors with equal scores are identified
    {
        PointColor[] targetArray = new PointColor[6];
        int[][] newScoreArray = new int[6][2];

        for (int i: scoreArray)
        {
            newScoreArray[i][0] = scoreArray[i];
            newScoreArray[i][1] = i;
        }

        int[][] resultArray = ModifiedBubblesort.bubble_srt(newScoreArray);

        for(int j = 0; j < 6; j++)
        {
            targetArray[j] = PointColor.values()[resultArray[j][1]];
        }

        return targetArray;
    }


    private enum PointColor {RED, GREEN, BLUE, ORANGE, YELLOW, PURPLE};

}
