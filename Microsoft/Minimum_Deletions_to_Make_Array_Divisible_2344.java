import java.util.*;
class Solution {
     static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
 
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int count=0;
            int result = numsDivide[0];
        for (int element: numsDivide){
            result = gcd(result, element);}

            for(int i=0;i<nums.length;i++){
                if(result%nums[i]!=0){
                    count++;
                }
                else{
                    return count;
                    }
            }
            return -1;
           
    }
}