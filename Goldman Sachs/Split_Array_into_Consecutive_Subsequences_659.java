class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> availMap = new HashMap<>();
        HashMap<Integer,Integer> wantMap = new HashMap<>();
        for(int i : nums){
            availMap.put(i, availMap.getOrDefault(i,0)+1);
        }
        for(int i=0;i<nums.length;i++){
            if(availMap.get(nums[i])<=0){
                continue;
            }
            else if(wantMap.getOrDefault(nums[i],0)>0){
                availMap.put(nums[i], availMap.getOrDefault(nums[i],0)-1);
                wantMap.put(nums[i], wantMap.getOrDefault(nums[i],0)-1);
                wantMap.put(nums[i]+1, wantMap.getOrDefault(nums[i]+1,0)+1);
            }
            else if(availMap.getOrDefault(nums[i],0)>0 && availMap.getOrDefault(nums[i]+1,0)>0 && availMap.getOrDefault(nums[i]+2,0)>0){
                availMap.put(nums[i], availMap.getOrDefault(nums[i],0)-1);
                availMap.put(nums[i]+1, availMap.getOrDefault(nums[i]+1,0)-1);
                availMap.put(nums[i]+2, availMap.getOrDefault(nums[i]+2,0)-1);
                wantMap.put(nums[i]+3, wantMap.getOrDefault(nums[i]+3,0)+1);
            }
            else{
                return false;
            }
            

    }
    return true;
}
