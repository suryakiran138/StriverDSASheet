package com.binarytree_part3;

// https://leetcode.com/problems/symmetric-tree/

import com.binarytree.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode x,TreeNode y){
        if(x==null && y==null) return true;
        if(x==null || y==null) return false;
        return x.val==y.val && isSymmetric(x.left,y.right) && isSymmetric(x.right,y.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }
}
