package com.arrays_part1;

// https://leetcode.com/problems/set-matrix-zeroes/

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        boolean[] isRowZero = new boolean[matrix.length];
        boolean[] isColZero = new boolean[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    isRowZero[i] = true;
                    isColZero[j] = true;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(isRowZero[i] || isColZero[j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
