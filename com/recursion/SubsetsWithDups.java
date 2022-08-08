package com.recursion;
import java.util.*;

// https://leetcode.com/problems/subsets-ii/

public class SubsetsWithDups {

    public void findSubsets(int index,int[] nums,List<Integer> list,List<List<Integer>> result){
        result.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            findSubsets(i+1,nums,list,result);
            list.remove(list.size()-1);
        }

    }



    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(0,nums,new ArrayList<>(),result);
        return result;
    }
}
