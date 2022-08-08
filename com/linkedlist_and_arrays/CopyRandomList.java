package com.linkedlist_and_arrays;

import java.util.*;

// https://leetcode.com/problems/copy-list-with-random-pointer/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = head;
        Node prev = null;
        Node result = null;
        Map<Node,Node> map = new HashMap<>();
        while(temp!=null){
            Node n1 = new Node(temp.val);
            if(prev!=null){
                prev.next = n1;
            } else {
                result = n1;
            }
            prev = n1;
            map.put(temp,n1);
            temp = temp.next;
        }
        Node temp1 = head;
        Node temp2 = result;
        while(temp1!=null){
            temp2.random = map.get(temp1.random);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return result;
    }
}
