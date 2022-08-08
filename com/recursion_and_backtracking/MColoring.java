package com.recursion_and_backtracking;

// https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#

public class MColoring {

    public boolean isSafe(boolean graph[][],int vertex,int[] colors,int color){
        // checking can i apply color color on vertex
        for(int i=0;i<graph.length;i++){
            if(graph[vertex][i] == true || graph[i][vertex]==true){
                if(colors[i] == color){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean colorGraph(int ind,boolean graph[][],int m,int[] colors){

        if(ind == colors.length) return true;

        for(int i=0;i<m;i++){
            if(isSafe(graph,ind,colors,i)){
                colors[ind] = i;
                if(colorGraph(ind+1, graph, m, colors)) return true;
                colors[ind] = -1;
            }
        }
        return false;
    }

    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] colors = new int[n];
        for(int i=0;i<n;i++){
            colors[i] = -1;
        }
        return colorGraph(0,graph,m,colors);

    }
}
