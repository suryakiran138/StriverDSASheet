package com.greedyalgorithm;
import java.util.*;

// https://www.codingninjas.com/codestudio/problems/975277?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

public class FindMinimumCoins {

    public static int findMinimumCoins(int amount)
    {
        // Write your code here.
        int V = amount;
        ArrayList < Integer > ans = new ArrayList < > ();
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int n = coins.length;
        for (int i = n - 1; i >= 0; i--) {
            while (V >= coins[i]) {
                V -= coins[i];
                ans.add(coins[i]);
            }
        }
        return ans.size();
    /*System.out.println("The minimum number of coins is "+ans.size());
    System.out.println("The coins are ");
    for (int i = 0; i < ans.size(); i++) {
      System.out.print(" " + ans.get(i));
    }*/
    }
}
