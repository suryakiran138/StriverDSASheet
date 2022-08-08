package com.linkedlist_and_arrays;

import com.linkedlist.ListNode;
import java.util.*;

// https://leetcode.com/problems/rotate-list/

public class RotateRight {

    public int findLength(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int len = findLength(head);
        if(len == 0) return head;
        k = k%len;
        if(len==0 || len==1 || k==0 || k==len) return head;
        //System.out.println("k: "+k+"len: "+len);
        ListNode temp = head;
        for(int i=0;i<len-k-1;i++){
            //System.out.println(temp.val);
            temp = temp.next;
        }
        // go to end of linked List
        ListNode next = temp.next;
        ListNode curr = temp;

        while(temp.next !=null){
            temp = temp.next;
        }

        temp.next = head;
        curr.next = null;
        head = next;
        return head;
    }
}
