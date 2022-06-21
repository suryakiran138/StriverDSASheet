package com.arrayspart4;
import java.util.*;
// https://leetcode.com/problems/longest-consecutive-sequence/

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        int max = 0;

        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            //System.out.println("i: "+i+" max: "+max+" result: "+result);
            if(nums[i+1]==nums[i]){
                continue;
            }
            if(nums[i+1]==nums[i]+1){
                max++;
            }else{
                if(max>result){
                    result = max;
                }
                max = 0;
            }
        }

        if(max>result){
            result=max;
        }



        return ++result;

    }
}
