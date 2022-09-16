package com.arrays_part1;

// https://leetcode.com/problems/sort-colors/

public class Sort0s1s2s {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        int len = nums.length;
        for(int i=0;i<len;i++){
            count[nums[i]] += 1;
        }
        int counter = 0;
        for(int i=0;i<3;i++){
            int iCount = count[i];
            for(int j=0;j<iCount;j++){
                nums[counter] = i;
                counter++;
            }
        }
    }
}
