package com.ingenious.algorithms.impl;
import java.util.Arrays;

public class GenericTree
{
    public GenericTree()
    {
        TreeNode<Integer> root = new TreeNode<>(2);
        TreeNode<Integer> child1 = new TreeNode<>(5);
        TreeNode<Integer> child2 = new TreeNode<>(4);


        root.addChild(child1);
            child1.addChild(2);
            child1.addChild(3);
        root.addChild(child2);
                child2.addChild(1);
        root.addChild(2);
        root.addChild(2);
        root.addChildren(Arrays.asList(
                new TreeNode<>(3),
                new TreeNode<>(2),
                new TreeNode<>(5)
        ));

        for(TreeNode node : root.getChildren())
        {
            System.out.println(node.getData());
        }
    }
}
