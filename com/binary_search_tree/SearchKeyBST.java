package com.binary_search_tree;

import com.binarytree.TreeNode;

// https://leetcode.com/problems/search-in-a-binary-search-tree/

public class SearchKeyBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(val == root.val) return root;
        else if(val < root.val) return searchBST(root.left,val);
        else return searchBST(root.right,val);
    }
}
