package com.binarytree;
import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

public class VerticalOrderTraversal {

    class TreeNodePair {
        TreeNode node;
        int col;
        int row;

        TreeNodePair(TreeNode node,int col,int row){
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<TreeNodePair>> map = new TreeMap<>();
        Queue<TreeNodePair> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        queue.add(new TreeNodePair(root,0,0));

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                TreeNodePair tp = queue.poll();
                if(map.containsKey(tp.col)){
                    List<TreeNodePair> list = map.get(tp.col);
                    list.add(tp);
                    map.put(tp.col,list);
                } else {
                    List<TreeNodePair> list = new ArrayList<>();
                    list.add(tp);
                    map.put(tp.col,list);
                }
                if(tp.node.left!=null)queue.add(new TreeNodePair(tp.node.left,tp.col-1,tp.row+1));
                if(tp.node.right!=null)queue.add(new TreeNodePair(tp.node.right,tp.col+1,tp.row+1));
            }

        }

        for(List<TreeNodePair> list: map.values()){
            /*for(TreeNodePair tp: list){
                System.out.println("val: "+tp.node.val+" col: "+tp.col+" row: "+tp.row);
            }*/
            Collections.sort(list, Comparator.comparingInt((TreeNodePair tp) -> tp.row)
                    .thenComparingInt( tp -> tp.node.val)
            );
        }

        return new ArrayList(map.values().stream().map(
                list -> list.stream().map(
                        tp -> tp.node.val
                ).collect(Collectors.toList())
        ).collect(Collectors.toList())
        );

    }

}
