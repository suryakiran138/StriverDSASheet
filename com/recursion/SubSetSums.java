package com.recursion;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/subset-sums2234/1

public class SubSetSums {

    void subSetHelper(int index,int sum,ArrayList<Integer> arr,int len,ArrayList<Integer> result){
        if(index == len){
            result.add(sum);
            return;
        }

        //with arr[index] in sum
        subSetHelper(index+1,sum+arr.get(index),arr,len,result);
        //with out arr[index] in sum
        subSetHelper(index+1,sum,arr,len,result);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> result = new ArrayList<>();

        subSetHelper(0,0,arr,N,result);
        return result;
    }
}
