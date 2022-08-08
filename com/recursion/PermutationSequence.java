package com.recursion;
import java.util.*;

//  https://leetcode.com/problems/permutation-sequence/

public class PermutationSequence {

    public int findFactorial(int n) throws Exception{
        if(n<0) throw new Exception("factorial can't be negative");
        if(n==0 || n==1) return 1;
        return n * findFactorial(n-1);
    }


    public String getPermutation(int n, int k) {

        List<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        String str = "";
        try{
            for(int i=0;i<n && k!=0;i++){
                int fact = findFactorial(n-i-1);
                int index = k/fact;
                k = k%fact;
                str += list.remove(k==0?index-1:index);
                //System.out.println("str: "+str+" k: "+k+" index: "+index);
            }
        } catch(Exception e){
            System.out.println(e);
        }

        while(!list.isEmpty()){
            str += list.remove(list.size()-1);
        }
        return str;

    }
}
