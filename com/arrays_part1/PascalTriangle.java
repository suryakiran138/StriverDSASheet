package com.arrays_part1;
import java.util.*;

// https://leetcode.com/problems/pascals-triangle/

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);

        for(int i=0;i<numRows;i++){
            result.add(i,new ArrayList<Integer>(i+1));
            for(int j=0;j<=i;j++){
                //System.out.println("i: "+i+" j: "+j);
                if(j==0 || j==i){
                    result.get(i).add(j,1);
                } else {
                    result.get(i).add(j,result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }

            }
        }

        return result;

    }
}
