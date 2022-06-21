package com.arrayspart4;
import java.util.*;
https://leetcode.com/problems/4sum/

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int l = j+1;
                int r = len-1;
                long diff = (long)target - (long)(nums[i]+nums[j]);
                while(r>l){
                    long temp = nums[l]+nums[r];
                    if(temp == diff){
                        result.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        int lVal = nums[l];
                        int rVal = nums[r];
                        //duplicates of l are skipped
                        while(l<r && nums[l]==lVal) l++;
                        //duplicates of r are skipped
                        while(l<r && nums[r]==rVal) r--;
                    } else if(temp<diff){
                        l++;
                    } else {
                        r--;
                    }
                }
                //duplicates of j are skipped
                while(j+1<len && nums[j+1]==nums[j]) j++;
            }
            //duplicates of i are skipped
            while(i+1<len && nums[i+1]==nums[i]) i++;
        }
        return result;
    }
}
