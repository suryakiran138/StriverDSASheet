package com.binarytree;

import java.util.*;

// https://leetcode.com/problems/binary-tree-postorder-traversal/

public class PostorderTraversal {
    public void helper(TreeNode root,List<Integer> res){
        if(root == null) return;

        helper(root.left,res);
        helper(root.right,res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
}
