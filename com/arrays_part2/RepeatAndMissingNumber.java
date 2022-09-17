package com.arrays_part2;
import java.util.*;

// https://www.interviewbit.com/problems/repeat-and-missing-number-array/

public class RepeatAndMissingNumber {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int len = A.size();
        int[] freq = new int[A.size()+1];
        for(int num: A){
            freq[num]++;
        }
        int repeat = 0;
        int missing = 0;
        for(int i=1;i<len+1;i++){
            if(freq[i]==0){
                missing = i;
            }
            if(freq[i]==2){
                repeat = i;
            }
        }
        return new ArrayList<Integer>(Arrays.asList(repeat,missing));

    }
}
