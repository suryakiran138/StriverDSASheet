package com.binarytree_part2;

import com.binarytree.TreeNode;

// https://leetcode.com/problems/balanced-binary-tree/

public class IsHeightBalanced {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left==-1 || right == -1 || Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
    }
}
