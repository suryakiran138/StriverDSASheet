package com.binary_search_tree_part1;

public class Floor {
    public  static int findCeil(Ceil.TreeNode<Integer> node, int x) {

        // Write your code here
        int ceil = -1;
        while(node!=null){
            if(x==node.data){
                return x;
            } else if(x>node.data){
                node = node.right;
            } else {
                ceil = node.data;
                node = node.left;
            }
        }
        return ceil;
    }
}
