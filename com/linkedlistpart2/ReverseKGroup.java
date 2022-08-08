package com.linkedlistpart2;

import com.linkedlist.ListNode;
import java.util.*;

// https://leetcode.com/problems/reverse-nodes-in-k-group/

public class ReverseKGroup {

    public int findLength(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null||head.next == null) return head;

        int length = findLength(head);

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur;
        ListNode nex;

        while(length >= k) {
            cur = pre.next;
            nex = cur.next;
            for(int i=1;i<k;i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            length -= k;
        }
        return dummyHead.next;
    }
}
