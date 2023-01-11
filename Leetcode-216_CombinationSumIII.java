import java.util.*;

class Solution {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSum3(int k, int n, int start, List<Integer> combination,
            List<List<Integer>> result) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            combination.add(i);
            combinationSum3(k - 1, n - i, i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
