class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                int dist = getDistance(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }

            for (int v : map.values()) {
                r += v * (v - 1);
            }
            map.clear();
        }

        return r;
    }

    private int getDistance(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];

        return x * x + y * y;
    }
}