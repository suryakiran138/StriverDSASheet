package com.binary_search_tree;

import com.binarytree.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

public class LCAofBST {

    public TreeNode firstEncounteredNode(TreeNode root, int min, int max){
        if(root==null) return null;
        if(root.val>=min && root.val<=max) return root;
        else if(root.val>max) return firstEncounteredNode(root.left,min,max);
        else return firstEncounteredNode(root.right,min,max);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val,q.val);
        int max = Math.max(p.val,q.val);
        return firstEncounteredNode(root,min,max);
    }
}
