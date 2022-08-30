package com.binarytree;
import java.util.*;

// https://www.interviewbit.com/problems/path-to-given-node/

public class NodePath {

    public boolean findPath(TreeNode node, int target,ArrayList<Integer> res){
        if(node == null) return false;
        res.add(node.val);
        if(node.val == target){
            return true;
        }
        if(findPath(node.left,target,res) || findPath(node.right,target,res)) {
            return true;
        }
        res.remove(res.size()-1);
        return false;
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        findPath(A, B, res);
        return res;
    }
}
