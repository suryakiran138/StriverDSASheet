package com.linkedlist;

// https://leetcode.com/problems/merge-two-sorted-lists/

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode temp = null;
        if(list1.val>list2.val){
            temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode res = list1;

        while(list2!=null){
            while(list1!=null && list1.val<=list2.val){
                temp = list1;
                //System.out.println("val1: "+list1.val+"val2: "+list2.val);
                list1 = list1.next;
            }
            //System.out.println("Outside");
            temp.next = list2;
            //System.out.println("val1: "+temp.val+"val2: "+temp.next.val);
            temp = list1;
            list1 = list2;
            list2 = temp;
        }

        return res;

    }
}
