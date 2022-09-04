package com.binarytree_part3;

import com.binarytree.TreeNode;

import java.util.*;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class ConstructTreeFromInorderAndPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> inMap){
        if(preStart>preEnd || inStart>inEnd) return null;
        int val = preorder[preStart];
        int rootIndex = inMap.get(val);
        int numsLeft = rootIndex - preStart;
        TreeNode left = buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, rootIndex-1, inMap);
        TreeNode right = buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, rootIndex+1, inEnd, inMap);
        return new TreeNode(val, left, right);
    }
}
