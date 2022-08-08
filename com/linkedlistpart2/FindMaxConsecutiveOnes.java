package com.linkedlistpart2;

// https://leetcode.com/problems/max-consecutive-ones/

public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int max = 0,result = 0;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                if(max==0){
                    max = max + 2;
                } else {
                    max = max+ 1;
                }
            }else {
                if(max>result) result = max;
                max = 0;
            }
            //System.out.println("i: "+i+" max: "+max);
        }
        /*if(nums[n-1]==nums[n-2]){
                max++;
        }*/
        if(max>result) result = max;
        return result;

    }
}
