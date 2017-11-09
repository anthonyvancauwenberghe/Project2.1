package com.ingenious.algorithms.impl;

public class alphabeta
{
    public int AlphaBeta(TreeNode node, int depth, int alpha, int beta, Boolean maximizing)
    {
        if(depth == 0 ||  node.hasChildren())
        {
            return (int)node.getData();
        }
        if(maximizing)
        {
            int v = -100;
            for(Object childNode : node.getChildren())
            {
                v = maxNum(v, AlphaBeta((TreeNode) childNode, depth - 1, alpha, beta, false));
                alpha = maxNum(alpha, v);
                if(beta <= alpha)
                    break;
            }
            return v;
        }
        else
        {
            int v = 100;
            for(Object childNode : node.getChildren())
            {
                v = minNum(v, AlphaBeta((TreeNode) childNode, depth - 1, alpha, beta, true));
                beta = minNum(beta, v);
                if(beta <= alpha)
                    break;
            }
            return v;
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
