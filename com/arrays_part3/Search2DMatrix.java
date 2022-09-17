package com.arrays_part3;
// https://leetcode.com/problems/search-a-2d-matrix/

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n - 1;
        int mid = 0;
        while(low<=high){
            mid = high+low/2;
            if(matrix[mid/n][mid%n]==target){
                return true;
            } else if(matrix[mid/n][mid%n]<target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;

    }
}
