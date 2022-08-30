package com.binarytree;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

public class BottomView {

    class Node{
        int data;
        int hd;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        Queue<Node> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        root.hd = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Node node = queue.poll();
                map.put(node.hd,node.data);
                if(node.left!=null){
                    node.left.hd = node.hd - 1;
                    queue.add(node.left);
                }
                if(node.right!=null){
                    node.right.hd = node.hd + 1;
                    queue.add(node.right);
                }

            }
        }
        return new ArrayList<Integer>(map.values());

    }
}
