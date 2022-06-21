package com.arrayspart4;
import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        /*int length = 0;
        int result = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            Set<Character> set = new HashSet<>();
            length = 0;
            for(int j=i;j<len;j++){
                char c = s.charAt(j);
                if(set.contains(c)){
                    //System.out.println("i: "+i+" j: "+j+" c: "+c);
                    break;
                } else {
                    set.add(c);
                    length++;
                }
            }
            result = Math.max(result,length);
        }
        return result;*/
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int length = 0;
        int result = 0;
        int len = s.length();
        while(r<len){
            char c = s.charAt(r);
            if(map.get(c)!=null){
                l = Math.max(map.get(c) + 1,l);
            }
            result = Math.max(result,r-l+1);
            map.put(c,r);
            r++;
            //System.out.println("c: "+c+" result: "+result);
        }
        return result;
    }
}
