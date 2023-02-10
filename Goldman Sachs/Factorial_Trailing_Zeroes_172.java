class Solution {
    public int trailingZeroes(int n) {
        int w = n;
        String str = "";
        if (n == 0) {
            return 0;
        } else {
            w = n / 5;
            return w + trailingZeroes(n / 5);
        }

    }
}