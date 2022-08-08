package com.recursion;
import java.util.*;


// https://leetcode.com/problems/palindrome-partitioning/

public class PalindromePartitions {

    public boolean isPalindrome(String s){
        int len = s.length();
        if(len<2) return true;
        for(int i=0;i<len/2;i++){
            if(s.charAt(i) != s.charAt(len-i-1))
                return false;
        }
        return true;
    }

    public void partitionHelper(String str,List<List<String>> result,List<String> path){
        if(str==null || str.length()==0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=1;i<=str.length();i++){
            String temp = str.substring(0,i);
            if(!isPalindrome(temp)) {
                System.out.println(temp +" is not palindrome");
                continue;
            }{
                System.out.println(temp +" is palindrome");
            }
            path.add(temp);
            System.out.println("str: "+str.substring(i,str.length())+" path: "+Arrays.toString(path.toArray()));
            partitionHelper(str.substring(i,str.length()),result,path);
            path.remove(path.size()-1);
        }

    }


    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        partitionHelper(s,result,new ArrayList<>());
        return result;
    }
}
