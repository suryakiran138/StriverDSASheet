package com.binarytree_part2;
import java.util.*;

// https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

public class BoundaryTraversal {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    public static void addLeafNodes(TreeNode root,ArrayList<Integer> res){
        if(root==null) return;
        if(root.left==null && root.right==null){
            res.add(root.data);
        }
        if(root.left!=null) addLeafNodes(root.left, res);
        if(root.right!=null) addLeafNodes(root.right, res);
    }
    public static ArrayList<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        res.add(root.data);
        TreeNode temp = root.left;
        if(temp!=null){
            while(temp.left!=null || temp.right!=null){
                res.add(temp.data);
                if(temp.left!=null) temp=temp.left;
                else temp = temp.right;
            }
        }
        temp = root;
        if(root.left!=null || root.right!=null) addLeafNodes(temp, res);
        temp = root.right;
        Stack<Integer> stack = new Stack<>();
        if(temp!=null){
            while(temp.left!=null || temp.right!=null){
                stack.add(temp.data);
                if(temp.right!=null) temp=temp.right;
                else temp = temp.left;
            }
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
