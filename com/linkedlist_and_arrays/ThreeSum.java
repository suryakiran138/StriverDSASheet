package com.linkedlist_and_arrays;

import java.util.*;

// https://leetcode.com/problems/3sum/

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<nums.length - 2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                //System.out.println("i: "+i);
                int low = i+1,high = nums.length-1,sum = 0-nums[i];
                while(low<high){
                    //System.out.println("i: "+i+"low: "+low+" high: "+high+" 1: "+nums[i]+" 2: "+nums[low]+" 3: "+nums[high]);
                    if(nums[low]+nums[high] == sum){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        result.add(temp);

                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;

                        low++;
                        high--;
                    } else if(nums[low]+nums[high] < sum){
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return result;
    }
}
