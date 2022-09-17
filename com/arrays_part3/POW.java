package com.arrays_part3;

// https://leetcode.com/problems/powx-n/

public class POW {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if(n<0) nn = -1*nn;
        while(nn>0){
            if(nn%2==1){
                //System.out.println("if ans: "+ans);
                ans = ans * x;
                nn = nn-1;
            }else {
                //System.out.println("else ans: "+ans);
                x = x*x;
                nn = nn/2;
            }
        }
        if(n<0) ans = (double)1.0/(double)ans;
        return ans;
    }
}
