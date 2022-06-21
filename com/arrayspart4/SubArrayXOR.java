package com.arrayspart4;
import java.util.*;
//  https://www.interviewbit.com/problems/subarray-with-given-xor/

public class SubArrayXOR {
    public int solve(ArrayList<Integer> A, int B) {
        int xorr = 0;
        int result = 0;
        Map<Integer,Integer> freq = new HashMap<>();
        /*for(int i=0;i<A.size();i++){
            val=0;
            for(int j=i;j<A.size();j++){
                val ^=  A.get(j);
                if(val == B){
                    //System.out.println("i: "+i+" j: "+j+"val: "+A.get(j));
                    result++;
                }
            }
        }*/

        for(int i=0;i<A.size();i++){
            xorr = xorr ^ A.get(i);
            if(freq.get(xorr^B) != null){
                result += freq.get(xorr^B);
            }
            if(xorr == B){
                result++;
            }
            if(freq.get(xorr)!=null){
                freq.put(xorr,freq.get(xorr)+1);
            } else {
                freq.put(xorr,1);
            }
        }

        return result;
    }
}
