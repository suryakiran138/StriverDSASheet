package com.recursion;
import java.util.*;

//  https://leetcode.com/problems/combination-sum-ii/

public class CombinationSum2 {
    public void findCombinations(int ind,int[] arr,int target,List<List<Integer>> result,List<Integer> ds){
        if(target==0){
            result.add(new ArrayList<>(ds));
            return;
        }
        if(target<0) return;
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            ds.add(arr[i]);
            findCombinations(i+1,arr,target-arr[i],result,ds);
            ds.remove(ds.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0,candidates,target,result,new ArrayList<>());
        return result;
    }
}
