package com.binary_search_tree_part1;

// https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=0

public class Ceil {

    class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.

        int floor = -1;
        while(root != null){
            if(X == root.data){
                return X;
            }else if(X < root.data){
                root = root.left;
            } else {
                floor=root.data;
                root = root.right;
            }
        }
        return floor;
    }
}
