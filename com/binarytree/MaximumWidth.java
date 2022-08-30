package com.binarytree;
import java.util.*;

// https://leetcode.com/problems/maximum-width-of-binary-tree/

public class MaximumWidth {
    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();
        int ans = 0;
        queue.add(new Pair(root,1));
        int first=0,last = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair p = queue.poll();
                TreeNode node = p.node;
                int index = p.index;
                //System.out.println("val: "+node.val+" index: "+index);
                if(i==0) first = index;
                if(i==size-1) last = index;
                if(node.left!=null) queue.add(new Pair(node.left,2*index));
                if(node.right!=null) queue.add(new Pair(node.right,2*index+1));
            }

            ans = Math.max(ans, last-first+1);
            //System.out.println("ans: "+ans+" first: "+first+" last: "+last);
        }

        return ans;


    }
}
