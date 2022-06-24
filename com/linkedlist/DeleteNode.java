package com.linkedlist;

// https://leetcode.com/problems/delete-node-in-a-linked-list/

public class DeleteNode {
    public void deleteNode(ListNode node) {
        if(node==null || node.next==null){
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
