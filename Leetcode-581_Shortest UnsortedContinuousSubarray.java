import java.util.*;
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int arr[]=new int[nums.length];
        int res1=0;
        int res2=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        for(int i=0;i<nums.length;i++){
            if(arr[i]!=nums[i]){
                res1=i;
                break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(arr[i]==nums[i]){
                count++;
            }
        }
        if(count==nums.length){
            return 0;
        }
        
         for(int i=nums.length-1;i>=0;i--){
            if(arr[i]!=nums[i]){
                res2=i;
                break;
            }
        }
        if(nums.length==1){
            return 0;
        }
        return (res2-res1)+1;
    }
}