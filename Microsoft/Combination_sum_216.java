class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> currCombination = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        makeCombination(k, n, 1);
        return ans;
    }

    public void makeCombination(int k, int n, int start) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(currCombination));
            return;
        }
        for (int i = start; i < 10; ++i) {
            currCombination.add(i);
            makeCombination(k - 1, n - i, i + 1);
            currCombination.remove(currCombination.size() - 1);
        }
    }
}