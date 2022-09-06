package com.binary_search_tree_part1;

import com.binarytree.TreeNode;

// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

public class MaxSumBST {
    class NodeWrapper {
        TreeNode node;
        int min,max,sum;
        boolean isBST;
        NodeWrapper(TreeNode node) {
            this.node = node;
            this.min = node.val;
            this.max = node.val;
            this.sum = node.val;
            this.isBST = true;
        }
    }
    private int maxSum;
    public NodeWrapper findNodeWrapper(TreeNode node){
        if(node == null){
            return null;
        }
        NodeWrapper left = findNodeWrapper(node.left);
        NodeWrapper right = findNodeWrapper(node.right);
        NodeWrapper curr = new NodeWrapper(node);
        if(left!=null){
            curr.sum += left.sum;
            curr.min = Math.min(curr.min,left.min);
            curr.max = Math.max(curr.max, left.max);
            curr.isBST = left.isBST && node.val > left.max;
        }
        if(right!=null){
            curr.sum += right.sum;
            curr.min = Math.min(curr.min,right.min);
            curr.max = Math.max(curr.max, right.max);
            curr.isBST &= right.isBST && node.val < right.min;
        }

        if(curr.isBST){
            maxSum = Math.max(maxSum,curr.sum);
        }
        //System.out.println("val: "+node.val+" min: "+curr.min+" max: "+curr.max+"max"+" sum: "+curr.sum);
        return curr;

    }

    public int maxSumBST(TreeNode root) {
        NodeWrapper nw = findNodeWrapper(root);
        return maxSum < 0 ? 0 : maxSum;
    }
}
