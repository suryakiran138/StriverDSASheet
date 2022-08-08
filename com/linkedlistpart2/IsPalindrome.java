package com.linkedlistpart2;

import com.linkedlist.ListNode;
import java.util.*;

// https://leetcode.com/problems/palindrome-linked-list/

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            stack.add(temp);
            temp = temp.next;
        }
        temp = head;
        while(!stack.isEmpty()){
            //System.out.println("ll value: "+temp.val+" stack val: "+stack.peek().val);
            if(temp.val != stack.pop().val){
                return false;
            }
            temp = temp.next;
        }
        return true;

    }
}
