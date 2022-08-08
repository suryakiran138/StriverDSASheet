package com.recursion;
import java.util.*;

// https://leetcode.com/problems/combination-sum/

public class CombinationSum {

    public void findCombinations(int index,int[] candidates,int target,List<List<Integer>> result,List<Integer> ds){
        if(index==candidates.length){
            if(target==0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[index]<=target){
            ds.add(candidates[index]);
            findCombinations(index,candidates,target-candidates[index],result,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(index+1,candidates,target,result,ds);

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0,candidates, target, result,new ArrayList<>());
        return result;
    }
}
