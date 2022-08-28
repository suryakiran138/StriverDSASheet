package com.heap;
import java.util.*;

// https://www.interviewbit.com/problems/maximum-sum-combinations/

public class MaximumSumCombinations {
    class Pair {
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
        @Override public boolean equals(Object o)
        {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair obj = (Pair)o;
            return (x == obj.x && y == obj.y);
        }

        @Override public int hashCode()
        {
            return Objects.hash(x, y);
        }
    }
    class Triplet {
        int sum,x,y;
        Triplet(int sum,int x,int y){
            this.sum = sum;
            this.x = x;
            this.y = y;
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A);
        Collections.sort(B);
        PriorityQueue<Triplet> maxHeap = new PriorityQueue<>((a,b) -> b.sum-a.sum);
        Set<Pair> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        int x = A.size()-1; int y = B.size()-1;
        set.add(new Pair(x,y));
        maxHeap.add(new Triplet(A.get(x)+B.get(y),x,y));

        for(int i=0;i<C;i++){
            Triplet tri = maxHeap.poll();
            res.add(tri.sum);

            if(tri.y>-1 && !set.contains(new Pair(tri.x,tri.y-1))){
                maxHeap.add(new Triplet(A.get(tri.x)+B.get(tri.y-1),tri.x,tri.y-1));
                set.add(new Pair(tri.x,tri.y-1));
            }

            if(tri.x>-1 && !set.contains(new Pair(tri.x-1,tri.y))){
                maxHeap.add(new Triplet(A.get(tri.x-1)+B.get(tri.y),tri.x-1,tri.y));
                set.add(new Pair(tri.x-1,tri.y));
            }
        }
        return res;
    }
}
