package com.binary_search_tree_part1;

import com.binarytree.TreeNode;

import java.util.*;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

public class FindPairSum {
    public boolean findSumPair(TreeNode root, int k, Set<Integer> set){
        if(root==null) return false;
        if(findSumPair(root.left,k,set)) return true;
        if(set.contains(k-root.val)){
            return true;
        }else {
            set.add(root.val);
        }
        return findSumPair(root.right,k,set);
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findSumPair(root,k,set);
    }
}
