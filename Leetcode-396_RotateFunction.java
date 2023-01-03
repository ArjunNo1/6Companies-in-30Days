class Solution {
    public int maxRotateFunction(int[] nums) {
      int sum=0;
      int n=nums.length;
      int res=0;
      for(int i=nums.length-1;i>=0;i--){
           sum+=nums[i];
           res+=i*nums[i];
       }
       int max=res;
     for(int i=nums.length-1;i>=0;i--){
         res += sum;
         res -= (nums[i]*n);
         max=Math.max(res,max);

     }
     return max;
    }
}