package com.binarytree;

import java.util.*;

// https://leetcode.com/problems/binary-tree-inorder-traversal/

public class MorriesInorder {
    public void morriesTraversal(TreeNode root,List<Integer> res){
        TreeNode curr,pre;
        if(root==null) return;
        curr = root;
        while(curr!=null){
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while(pre.right!=null && pre.right!=curr){
                    pre = pre.right;
                }
                if(pre.right==null){
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }

    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        morriesTraversal(root,res);
        return res;
    }
}
