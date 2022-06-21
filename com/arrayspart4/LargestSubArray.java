package com.arrayspart4;
import java.util.*;
// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

public class LargestSubArray {
    int maxLen(int arr[], int n)
    {
        // Your code here
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum == 0){
                max = i+1;
            } else {
                if(map.get(sum) != null){
                    max = Math.max(max, i-map.get(sum));
                } else {
                    map.put(sum,i);
                }
            }
        }
        return max;
    }
}
