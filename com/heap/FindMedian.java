package com.heap;
import java.util.*;

// https://leetcode.com/problems/find-median-from-data-stream/

public class FindMedian {

    PriorityQueue<Integer> pq1,pq2;

    public FindMedian() {
        this.pq1 = new PriorityQueue<>(Collections.reverseOrder());
        this.pq2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int s1 = pq1.size();
        int s2 = pq2.size();
        if(s1==0){
            pq1.add(num);
            return;
        }
        if(s2==0){
            if(num<pq1.peek()){
                pq2.add(pq1.poll());
                pq1.add(num);
            }else {
                pq2.add(num);
            }
            return;
        }
        if(s1>s2){
            if(num<pq1.peek()){
                pq2.add(pq1.poll());
                pq1.add(num);
            } else {
                pq2.add(num);
            }
        } else if(s1<s2){
            if(num>pq2.peek()){
                pq1.add(pq2.poll());
                pq2.add(num);
            } else {
                pq1.add(num);
            }
        } else {
            if(num<pq1.peek()){
                pq1.add(num);
            } else {
                pq2.add(num);
            }
        }
    }

    public double findMedian() {
        int s1 = pq1==null?0:pq1.size();
        int s2 = pq2==null?0:pq2.size();
        if(s1>s2){
            return (double)pq1.peek();
        } else if(s1<s2){
            return (double)pq2.peek();
        } else {
            return (pq1.peek()+pq2.peek())/2.0;
        }

    }
}
