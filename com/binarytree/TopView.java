package com.binarytree;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

public class TopView {

    static class VerticalLevel {
        Node node;
        int level;

        VerticalLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }

    }

    static ArrayList<Integer> topView(Node root) {
        // add your code
        Queue<VerticalLevel> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new VerticalLevel(root, 0));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                VerticalLevel vl = queue.poll();
                map.putIfAbsent(vl.level, vl.node.data);
                if (vl.node.left != null) {
                    queue.add(new VerticalLevel(vl.node.left, vl.level - 1));
                }
                if (vl.node.right != null) {
                    queue.add(new VerticalLevel(vl.node.right, vl.level + 1));
                }

            }
        }
        return new ArrayList<Integer>(map.values());
    }
}
