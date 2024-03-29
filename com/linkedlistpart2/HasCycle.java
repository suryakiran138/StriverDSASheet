package com.linkedlistpart2;

import com.linkedlist.ListNode;
import java.util.*;

// https://leetcode.com/problems/linked-list-cycle/

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
