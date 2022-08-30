package com.binarytree;

import java.util.*;

// https://leetcode.com/problems/binary-tree-preorder-traversal/

public class MorrisPreorder {

    public void morrisPreorder(TreeNode root,List<Integer> res){
        TreeNode curr,prev;
        if(root==null) return;
        curr = root;
        while(curr != null){
            if(curr.left==null){
                res.add(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                if(prev.right==null){
                    res.add(curr.val);
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        morrisPreorder(root,res);
        return res;
    }
}
