package com.binarytree_part3;

import com.binarytree.TreeNode;

import java.util.*;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

public class ConstructTreeFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap = new HashMap<>(inorder.length);
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inMap);
    }

    public TreeNode buildTree(int[] inorder,int inStart,int inEnd,int[] postorder,
                              int postStart, int postEnd, Map<Integer,Integer> inMap){
        if(inStart>inEnd || postStart>postEnd) return null;
        int value = postorder[postEnd];
        int index = inMap.get(value);
        int leftLength = index - inStart;
        TreeNode left = buildTree(inorder,inStart,inStart+leftLength-1,postorder,postStart,postStart+leftLength-1,inMap);
        TreeNode right = buildTree(inorder, index+1, inEnd, postorder,postStart+leftLength,postEnd-1,inMap);
        return new TreeNode(value, left, right);
    }
}
