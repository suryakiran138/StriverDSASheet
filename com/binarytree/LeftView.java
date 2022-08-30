package com.binarytree;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

public class LeftView {

    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.peek();
            res.add(curr.data);
            int len = queue.size();
            for(int i=0;i<len;i++){
                curr = queue.poll();
                if(curr.left!=null)queue.add(curr.left);
                if(curr.right!=null)queue.add(curr.right);
            }
        }
        return res;
    }
}
