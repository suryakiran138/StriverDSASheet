package com.binarytree;

import java.util.*;

// https://leetcode.com/problems/binary-tree-preorder-traversal/


public class PreorderTraversal {

    public void helper(TreeNode root,List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        helper(root.left,res);
        helper(root.right,res);
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

}
