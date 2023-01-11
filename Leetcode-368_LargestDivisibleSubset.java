import java.util.*;
class Solution {

    public static int divisiblesize(int nums[],int arr[]){
        Arrays.sort(nums);
        Arrays.fill(arr,1);
        int result_size=1;
       
        

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    arr[i]=Math.max(arr[i],arr[j]+1);
                    result_size=Math.max(result_size,arr[i]);
                }
            }
        }
        return result_size;
    }

    public static List<Integer> subset(int nums[],int arr[],int size){
         for (int i : arr) {
            System.out.println(i);
        }
        LinkedList<Integer>res=new LinkedList<>();
        int last=-1;
        for(int i=nums.length-1;i>=0;i--){
            if(arr[i]==size && (last==-1 || last%nums[i]==0)){
                res.addFirst(nums[i]);
                size--;
                last=nums[i];
            }
        }
        return res;
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        return subset(nums,arr,divisiblesize(nums,arr));
    }
}