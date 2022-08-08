package com.linkedlistpart2;

import com.linkedlist.ListNode;
import java.util.*;

// https://leetcode.com/problems/intersection-of-two-linked-lists/

public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();
        Set<ListNode> setB = new HashSet<>();

        ListNode l1 = headA;

        ListNode l2 = headB;
        while(l1!=null || l2!=null){
            if(l1!=null) {
                setA.add(l1);
            }
            if(l2!=null) {
                setB.add(l2);
            }

            if(setA.contains(l2)){
                return l2;
            }

            if(setB.contains(l1)){
                return l1;
            }
            if(l1!=null) {
                l1 = l1.next;
            }
            if(l2!=null) {
                l2 = l2.next;
            }
        }

        return null;
    }
}
