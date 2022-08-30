package com.binarytree;
import java.util.*;

// https://www.codingninjas.com/codestudio/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

public class AllTraversals {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    static class NodeWithNum {
        BinaryTreeNode<Integer> node;
        int num;
        NodeWithNum(BinaryTreeNode<Integer> node, int num){
            this.node = node;
            this.num = num;
        }
    }


    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.

        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root==null) return res;

        Stack<NodeWithNum> stack = new Stack<>();
        stack.add(new NodeWithNum(root,1));

        while(!stack.isEmpty()){
            BinaryTreeNode<Integer> node = stack.peek().node;
            int num = stack.peek().num;
            if(num == 1){
                preOrder.add(node.data);
                stack.peek().num++;
                if(node.left!=null)stack.add(new NodeWithNum(node.left,1));
            }else if(num == 2){
                inOrder.add(node.data);
                stack.peek().num++;
                if(node.right!=null)stack.add(new NodeWithNum(node.right,1));
            }else if(num == 3){
                postOrder.add(node.data);
                stack.pop();
            }
        }
        res.add(inOrder);
        res.add(preOrder);
        res.add(postOrder);
        return res;
    }
}
