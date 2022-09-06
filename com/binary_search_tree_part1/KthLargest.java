package com.binary_search_tree_part1;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

public class KthLargest {
    public int findCount(Node root){
        if(root==null) return 0;
        return 1 + findCount(root.left) + findCount(root.right);
    }
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        int count = 0;
        int size = findCount(root);

        while(curr!=null || !stack.isEmpty()){

            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if(++count == size-K+1) return curr.data;
            curr = curr.right;
        }
        return root.data;
    }
}
