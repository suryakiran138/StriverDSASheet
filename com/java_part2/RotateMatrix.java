package com.java_part2;

// https://leetcode.com/problems/rotate-image/

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // Transpose
        for(int i=0;i<len;i++){
            for(int j=0;j<=i;j++){
                if(i!=j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        // column inverse
        for(int i=0;i<len;i++){
            for(int j=0;j<len/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = temp;
            }
        }

    }
}
