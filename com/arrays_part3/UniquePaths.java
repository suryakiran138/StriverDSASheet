package com.arrays_part3;

// https://leetcode.com/problems/unique-paths/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // we need to find N C r
        int N = m+n-2;
        int r = n-1;
        double ans = 1;
        for(int i=1;i<=r;i++){
            ans = ans * (N-r+i)/i;
        }
        return (int)ans;
    }
}
