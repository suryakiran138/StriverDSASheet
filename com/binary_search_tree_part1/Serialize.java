package com.binary_search_tree_part1;

import com.binarytree.TreeNode;

import java.util.*;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

public class Serialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        String str = "";
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                str += node==null ? "N " : node.val+" ";
                if(node!=null){
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty()) return null;
        //System.out.println("data: "+data);
        String[] vals = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int counter = 1;
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            //System.out.println("curr: "+curr.val);
            if(curr!=null){
                String str = vals[counter++];
                if(!str.equals("N")){
                    curr.left = new TreeNode(Integer.parseInt(str));
                    queue.add(curr.left);
                }
                str = vals[counter++];
                if(!str.equals("N")){
                    curr.right = new TreeNode(Integer.parseInt(str));
                    queue.add(curr.right);
                }
            }

        }
        return root;
    }
}
