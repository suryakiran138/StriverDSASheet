package com.arrays_part3;

// https://leetcode.com/problems/majority-element/

public class MajorityElement1 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int elem = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] == elem){
                count++;
            }else if(count==0){
                elem = nums[i];
            } else {
                count--;
            }
        }

        return elem;

    }
}
