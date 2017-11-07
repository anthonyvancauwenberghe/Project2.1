package com.ingenious.algorithms.impl;

public class minimax
{
    public int MiniMax(TreeNode node, int depth, Boolean maximizing)
    {
        if(depth == 0 ||  node.hasChildren())
        {
            return (int)node.getData();
        }
        if(maximizing)
        {
            int bestvalue = -100;
            for(Object childNode : node.getChildren())
            {
                int v = MiniMax((TreeNode) childNode, depth - 1, false);
                bestvalue = maxNum(v, bestvalue);
            }
            return bestvalue;
        }
        else
        {
            int bestvalue = 100;
            for(Object childNode : node.getChildren())
            {
                int v = MiniMax((TreeNode) childNode, depth - 1, true);
                bestvalue = minNum(v, bestvalue);
            }
            return bestvalue;
        }
    }

    public int maxNum(int m, int n)
    {
        if(m >= n)
            return m;
        else
            return n;
    }
    public int minNum(int m, int n)
    {
        if(m <= n)
            return m;
        else
            return n;
    }
}
