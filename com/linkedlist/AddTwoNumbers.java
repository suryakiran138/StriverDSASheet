package com.linkedlist;
// https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {
    public ListNode reverseRecursive(ListNode head){
        ListNode temp = head;
        if(temp==null || temp.next==null){
            return head;
        }
        ListNode newHead = reverseRecursive(temp.next);
        temp.next.next = temp;
        temp.next = null;
        return newHead;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //l1 = reverseRecursive(l1);
        //l2 = reverseRecursive(l2);
        int carry = 0;
        int sum = 0;
        ListNode head=null,tail=null;
        while(l1!=null && l2!=null){
            sum = l1.val+l2.val+carry;

            carry = sum / 10;
            sum = sum % 10;
            if(head == null){
                head = new ListNode(sum);
                tail = head;
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1!=null){
            while(l1!=null){
                sum = l1.val+carry;
                carry = sum / 10;
                sum = sum % 10;
                tail.next = new ListNode(sum);
                tail = tail.next;
                l1 = l1.next;
            }
        }
        if(l2!=null){
            while(l2!=null){
                sum = l2.val+carry;
                carry = sum / 10;
                sum = sum % 10;
                tail.next = new ListNode(sum);
                tail = tail.next;
                l2 = l2.next;
            }
        }
        if(carry>0){
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        return head;
    }
}
