package com.recursion_and_backtracking;
import java.util.*;

//  https://leetcode.com/problems/permutations/

public class FindPermutations {
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void findPermutations(int ind,int[] nums,List<List<Integer>> res){
        if(ind == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            res.add(list);
            return;
        }

        for(int i=ind;i<nums.length;i++){
            swap(nums,i,ind);
            findPermutations(ind+1,nums,res);
            swap(nums,i,ind);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findPermutations(0,nums,res);
        return res;
    }
}
