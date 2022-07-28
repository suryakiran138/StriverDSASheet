package com.greedyalgorithm;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack {

    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(j,i) -> new Float((float)i.value/i.weight).compareTo(new Float((float)j.value/j.weight)));
        double result = 0;

        int remaining = W;

        for(Item i: arr){
            //System.out.println("value: "+i.value+" weight: "+i.weight);
            if(i.weight>remaining){
                result += (i.value * ((double)remaining/i.weight));
                break;
            } else {
                result += i.value;
                remaining -= i.weight;
            }
        }

        return result;
    }

}
