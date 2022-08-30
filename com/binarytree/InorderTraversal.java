package com.binarytree;

import java.util.*;

// https://leetcode.com/problems/binary-tree-inorder-traversal/

public class InorderTraversal {

    public void helper(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }

        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
}
