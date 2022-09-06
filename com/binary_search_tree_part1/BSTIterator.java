package com.binary_search_tree_part1;

import com.binarytree.TreeNode;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode root){
        for(;root!=null;root = root.left){
            stack.push(root);
        }
    }
}
