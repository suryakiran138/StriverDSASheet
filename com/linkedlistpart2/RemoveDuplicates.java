package com.linkedlistpart2;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int n=nums.length;
        int p1=0,p2=0;
        if(n==1) return 1;
        while(p1<n-1){
            if(nums[p1]==nums[p1+1]){
                p1++;
            }else{
                nums[p2] = nums[p1];
                p1++;
                p2++;
            }
        }


        nums[p2] = nums[p1];
        p2++;

        return p2;

    }
}
