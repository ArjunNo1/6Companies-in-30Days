class Solution {
    public int countNicePairs(int[] nums) {
        int j = nums.length - 1;
        int r = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            String str = Integer.toString(nums[i]);
            StringBuilder input1 = new StringBuilder();
            input1.append(str);
            input1.reverse();
            str = input1.toString();
            long diff = nums[i] - Integer.parseInt(str);
            if (map.containsKey(diff)) {
                r = (r % mod + map.get(diff) % mod) % mod;
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return r;
    }
}
