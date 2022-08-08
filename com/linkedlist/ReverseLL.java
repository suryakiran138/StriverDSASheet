package com.linkedlist;

// https://leetcode.com/problems/reverse-linked-list/

public class ListNode {
      public int val;
      public ListNode next;
      ListNode() {}
      public ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class ReverseLL {
    public ListNode reverseIterative(ListNode node){

        if(node==null || node.next==null){
            return node;
        }

        ListNode prev = node;
        ListNode curr = node.next;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        node.next = null;
        return prev;
    }

    public ListNode reverseRecursive(ListNode node){
        if(node==null || node.next == null){
            return node;
        }
        ListNode newNode = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;

    }
    public ListNode reverseList(ListNode head) {
        return reverseIterative(head);
    }
}
