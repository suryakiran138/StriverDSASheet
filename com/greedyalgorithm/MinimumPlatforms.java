package com.greedyalgorithm;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#

public class MinimumPlatforms {
    static class Train{
        int start;
        int end;
        Train(int start,int end){
            this.start = start;
            this.end = end;
        }

        public String toString(){
            return "Start: "+start+" End: "+end;
        }
    }


    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        ArrayList<Train> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            Train temp = new Train(arr[i],dep[i]);
            list.add(temp);
        }
        Collections.sort(list, (a,b)->a.start-b.start);
        PriorityQueue<Train> queue = new PriorityQueue<>(n,(a,b) -> a.end-b.end);

        int count = 0;

        for(Train t: list){
            if(queue.isEmpty()){
                //System.out.println("adding: "+t);
                queue.add(t);
                count++;
            } else {
                //System.out.println("peek: "+queue.peek());
                if(t.start <= queue.peek().end){
                    //System.out.println("size: "+queue.size()+" count: "+count+" if adding: "+t);
                    queue.add(t);
                    //if(count<=queue.size()) count++;
                } else {
                    while(!queue.isEmpty() && t.start>queue.peek().end){
                        //System.out.println("else removing: "+queue.peek());
                        queue.poll();
                    }
                    //System.out.println("else adding: "+t);
                    queue.add(t);
                }
            }
            if(count < queue.size()) count=queue.size();
        }

        return count;

    }
}
