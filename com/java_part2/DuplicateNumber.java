package com.java_part2;
import java.util.*;

// https://leetcode.com/problems/find-the-duplicate-number/

public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                return num;
            }
        }
        return 0;
    }
}
