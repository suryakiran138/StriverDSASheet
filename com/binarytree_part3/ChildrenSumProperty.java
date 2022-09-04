package com.binarytree_part3;

// https://www.codingninjas.com/codestudio/problems/childrensumproperty_790723?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

class BinaryTreeNode < Integer > {
    int data;
    BinaryTreeNode < Integer > left;
    BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}

public class ChildrenSumProperty {
    public static void changeTree(BinaryTreeNode< Integer > root) {
        // Write your code here.
        if(root==null) return;
        int total = 0;
        if(root.left!=null) total+=root.left.data;
        if(root.right!=null) total+=root.right.data;

        if(total<root.data){
            if(root.left!=null) root.left.data = root.data;
            if(root.right!=null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        total = 0;
        if(root.left!=null) total+=root.left.data;
        if(root.right!=null) total+=root.right.data;

        if(root.left!=null || root.right!=null) root.data = total;


    }
}
