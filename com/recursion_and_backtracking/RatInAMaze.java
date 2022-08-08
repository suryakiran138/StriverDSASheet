package com.recursion_and_backtracking;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

public class RatInAMaze {

    public static void solvePath(int[][] m,int n,int[][] vis,String path,ArrayList<String> res,int x,int y){

        if(x==n-1 && y==n-1){
            res.add(path);
            return;
        }

        String dir = "DLRU";
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};
        for(int i=0;i<dir.length();i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<n && vis[nx][ny]==0 && m[nx][ny]==1){
                vis[x][y] = 1;
                solvePath(m,n,vis,path+dir.charAt(i),res,nx,ny);
                vis[x][y] = 0;
            }
        }
    }


    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] vis = new int[n][n];
        ArrayList<String> res = new ArrayList<String>();
        if(m[0][0] == 0) return res;
        solvePath(m,n,vis,"",res,0,0);
        return res;
    }
}
