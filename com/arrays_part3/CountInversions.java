package com.arrays_part3;

// https://leetcode.com/problems/reverse-pairs/

public class CountInversions {
    public int merge(int[] nums,int start,int mid,int end){
        //find no of inversions
        int inv = 0;
        int y = mid+1;
        for(int x=start;x<=mid;x++){
            while(y<=end && nums[x] > (2*(long)nums[y])){
                y++;
            }
            inv += (y-(mid+1));
        }

        // create two arrays and copy in those arrays
        int[] arr1 = new int[mid-start+1];
        int[] arr2 = new int[end-mid];
        int count = start;
        for(int i=0;i<mid-start+1;i++){
            arr1[i] = nums[count++];
        }
        for(int i=0;i<end-mid;i++){
            arr2[i] = nums[count++];
        }
        //merge both the arrays
        int p1=0,p2=0;
        count=start;
        while(p1<mid-start+1 && p2<end-mid){
            if(arr1[p1]<arr2[p2])
                nums[count++] = arr1[p1++];
            else
                nums[count++] = arr2[p2++];
        }
        while(p1<mid-start+1){
            nums[count++] = arr1[p1++];
        }
        while(p2<end-mid){
            nums[count++] = arr2[p2++];
        }
        return inv;
    }


    public int mergeSort(int[] nums,int start,int end){
        if(start>=end) return 0;
        int mid = (start+end)/2;
        int inv = mergeSort(nums,start,mid);
        inv += mergeSort(nums,mid+1,end);
        inv += merge(nums,start,mid,end);
        return inv;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);

    }
}
