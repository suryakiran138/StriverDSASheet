package com.binarytree_part3;

import com.binarytree.TreeNode;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

public class FlattenTree {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
