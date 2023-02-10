class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum_in = 0;
        int sum_arr = 0;
        for (int i = 0; i < nums.length; i++) {
            sum_in += i * nums[i];
            sum_arr += nums[i];
        }
        int max = sum_in;
        for (int i = nums.length - 1; i > 0; i--) {
            sum_in = sum_in + sum_arr - (nums.length * nums[i]);
            max = Math.max(max, sum_in);
        }
        return max;
    }
}
