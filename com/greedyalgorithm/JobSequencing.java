package com.greedyalgorithm;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class JobSequencing {
    int getMaxDeadLine(Job arr[]){
        return Arrays.stream(arr).max((a,b) -> a.deadline-b.deadline).get().deadline;
    }
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a,b)->b.profit-a.profit);
        int maxDeadLine = getMaxDeadLine(arr);
        int[] temp = new int[maxDeadLine+1];
        for(int i=0;i<temp.length;i++){
            temp[i] = -1;
        }
        int index = -1;
        int count = 0;
        int max = 0;
        for(Job job:arr){
            index = job.deadline;
            while(index>0){
                if(temp[index]==-1){
                    temp[index] = job.id;
                    count++;
                    max += job.profit;
                    break;
                }
                index--;
            }

        }
        //System.out.println("temp: "+Arrays.toString(temp));
        int[] result = new int[2];
        result[0] = count;
        result[1] = max;
        return result;
    }
}
