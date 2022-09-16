package com.arrays_part1;

// https://leetcode.com/problems/maximum-subarray/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        int len = nums.length;

        for(int i=0;i<len;i++){
            localMax += nums[i];
            globalMax = Math.max(localMax,globalMax);
            if(localMax<0) localMax = 0;
        }
        return globalMax;

    }
}
