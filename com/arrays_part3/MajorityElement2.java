package com.arrays_part3;
import java.util.*;

// https://leetcode.com/problems/majority-element-ii/

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {

        int num1=Integer.MIN_VALUE,num2=Integer.MIN_VALUE,count1=0,count2=0,len=nums.length;
        for(int num: nums){
            if(num==num1) count1++;
            else if(num==num2) count2++;
            else if(count1==0){
                num1 = num;
                count1 = 1;
            } else if(count2==0){
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        count1=0;
        count2=0;
        for(int num:nums){
            if(num==num1) count1++;
            if(num==num2) count2++;
        }
        if(count1>len/3) list.add(num1);
        if(count2>len/3) list.add(num2);
        return list;

    }
}
