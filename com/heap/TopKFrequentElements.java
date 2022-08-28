package com.heap;
import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/

public class TopKFrequentElements {

    class Freq {
        int num,freq;
        Freq(int num,int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Freq> pq = new PriorityQueue<>((a,b) -> b.freq-a.freq);
        int count = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                count++;
            }else {
                pq.add(new Freq(nums[i],count));
                count = 1;
            }
        }
        if(nums.length!=1 && nums[nums.length-1] == nums[nums.length-2]){
            pq.add(new Freq(nums[nums.length-1],count));
        } else {
            pq.add(new Freq(nums[nums.length-1],1));
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll().num;
        }
        return res;
    }


}
