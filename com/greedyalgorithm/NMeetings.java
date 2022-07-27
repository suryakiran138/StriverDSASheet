package com.greedyalgorithm;

import java.util.*;
// https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

public class NMeetings {
    static class Meeting{
        int start;
        int end;
        Meeting(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Meeting> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            Meeting temp = new Meeting(start[i],end[i]);
            list.add(temp);
        }
        Collections.sort(list, (a,b)->a.end-b.end);
        int occupied = -1;
        int count = 0;
        for(Meeting m: list){
            if(m.start>occupied){
                count++;
                occupied = m.end;
            }
        }
        return count;
    }
}
