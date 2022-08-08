package com.linkedlistpart2;

import com.linkedlist.ListNode;
import java.util.*;

// https://leetcode.com/problems/linked-list-cycle-ii/

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                while(entry!=slow){
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }

        return null;
    }
}
