package com.linkedlist;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNode {
    public int findLength(ListNode head){
        ListNode temp = head;
        int length = 0;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = findLength(head);
        ListNode temp = head;
        int index = length-n+1;
        for(int i=1;i<index-1;i++){
            temp = temp.next;
        }
        if(index==1) return head.next;
        if(temp.next==null) return null;
        temp.next = temp.next.next;
        return head;
    }
}
