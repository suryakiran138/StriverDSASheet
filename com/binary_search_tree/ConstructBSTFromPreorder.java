package com.binary_search_tree;

import com.binarytree.TreeNode;

//  https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

public class ConstructBSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder,int start,int end) {
        if(start>end) return null;
        if(start==end) return new TreeNode(preorder[start]);;
        TreeNode node = new TreeNode(preorder[start]);
        int rStart = end+1;
        for(int i=start;i<=end;i++){
            if(preorder[i]>preorder[start]){
                rStart = i;
                break;
            }
        }
        //System.out.println("start: "+start+" end: "+end+" rStart: "+rStart);
        node.left = bstFromPreorder(preorder,start+1,rStart-1);
        node.right = bstFromPreorder(preorder,rStart,end);
        return node;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,0,preorder.length-1);
    }
}
