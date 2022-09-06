package com.binary_search_tree_part1;

import com.binarytree.TreeNode;

import java.util.*;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {

        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        while(curr!=null || !stack.isEmpty()){

            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if(++count == k) return curr.val;
            curr = curr.right;
        }
        return root.val;
    }
}
