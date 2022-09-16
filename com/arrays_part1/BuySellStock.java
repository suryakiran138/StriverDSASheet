package com.arrays_part1;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minValue = prices[0];
        int len = prices.length;
        if(len==1) return 0;
        for(int i=1;i<len;i++){
            minValue = Math.min(prices[i],minValue);
            maxProfit = Math.max(prices[i]-minValue,maxProfit);
        }
        return maxProfit;
    }
}

