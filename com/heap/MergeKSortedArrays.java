package com.heap;
import java.util.*;

// https://www.interviewbit.com/problems/merge-k-sorted-arrays/

public class MergeKSortedArrays {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int i=0;i<A.get(0).size();i++){
            for(int j=0;j<A.size();j++){
                pq.add(A.get(j).get(i));
            }
            res.add(pq.poll());
        }

        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
    }
}
