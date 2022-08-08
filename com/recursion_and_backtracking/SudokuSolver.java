package com.recursion_and_backtracking;

//  https://leetcode.com/problems/sudoku-solver/

public class SudokuSolver {
    public boolean isSafe(char[][] board,char val,int row,int col){
        // check in that row
        for(int i=0;i<9;i++){
            if(board[row][i] == val){
                return false;
            }
        }
        // check in that col
        for(int i=0;i<9;i++){
            if(board[i][col] == val){
                return false;
            }
        }
        // check in the block
        int a = 3*(row/3);
        int b = 3*(col/3);
        for(int i=a;i<a+3;i++){
            for(int j=b;j<b+3;j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve(char[][] board) {

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isSafe(board,k,i,j)){
                            board[i][j] = k;
                            if(solve(board)){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }




    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
