package com.binarytree_part2;
import com.binarytree.TreeNode;
import java.util.*;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            if(!leftToRight){
                Collections.reverse(list);
            }
            leftToRight = !leftToRight;
            res.add(list);
        }

        return res;

    }
}
