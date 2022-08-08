package com.recursion_and_backtracking;
import java.util.*;

// https://leetcode.com/problems/n-queens/

public class NQueens {
    public boolean isSafe(char[][] board,int row,int col){
        int n = board.length;
        // checking horizontally
        for(int i=0;i<n;i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }
        // checking vertically
        for(int i=0;i<n;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // checking top right
        for(int i=row,j=col;i>-1&&j<n;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // checking top left
        for(int i=row,j=col;i>-1&&j>-1;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // checking bottom right
        for(int i=row,j=col;i<n&&j<n;i++,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // cheking bottom left
        for(int i=row,j=col;i<n&&j>-1;i++,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public void saveBoard(char[][] board,List<List<String>> res){
        int n = board.length;
        List<String> newBoard = new ArrayList<>();
        for(int i=0;i<n;i++){
            String row = "";
            for(int j=0;j<n;j++){
                if(board[i][j] == 'Q'){
                    row += "Q";
                } else {
                    row += ".";
                }
            }
            newBoard.add(row);
        }
        res.add(newBoard);
    }

    public void helper(char[][] board,List<List<String>> res,int col) {
        int n = board.length;
        if(col == n){
            saveBoard(board,res);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(board,i,col)){
                board[i][col]  = 'Q';
                helper(board,res,col+1);
                board[i][col]  = '.';
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board,res,0);
        return res;
    }
}
