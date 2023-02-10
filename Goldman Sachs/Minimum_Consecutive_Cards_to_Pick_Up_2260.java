class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> m = new HashMap();
        int min = 1000000;
        for (int i = 0; i < cards.length; i++) {
            if (m.containsKey(cards[i])) {
                int curr = i - m.get(cards[i]);
                m.put(cards[i], i);
                min = Math.min(min, curr);
            } else {
                m.put(cards[i], i);
            }
        }
        if (min == 1000000)
            return -1;
        return min + 1;
    }
}