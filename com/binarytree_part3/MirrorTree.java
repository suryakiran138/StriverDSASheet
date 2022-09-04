package com.binarytree_part3;

//https://practice.geeksforgeeks.org/problems/mirror-tree/1

class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class MirrorTree {
    void mirror(Node node) {
        // Your code here
        if(node==null) return;
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }
}
