package com.heap;
import java.util.*;

// https://leetcode.com/problems/kth-largest-element-in-an-array/

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);
        }
        for(int i=0;i<nums.length-k;i++){
            pq.remove();
        }
        return pq.peek();
    }

}
