class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        HashSet<String> haset = new HashSet<String>();
        int area = 0;
        for (int[] a : rectangles) {
            x1 = Math.min(a[0], x1);
            x2 = Math.max(a[2], x2);
            y1 = Math.min(a[1], y1);
            y2 = Math.max(a[3], y2);

            area += (a[2] - a[0]) * (a[3] - a[1]);
            String s1 = a[0] + " " + a[1];
            String s2 = a[0] + " " + a[3];
            String s3 = a[2] + " " + a[3];
            String s4 = a[2] + " " + a[1];
            if (!haset.add(s1)) {
                haset.remove(s1);
            }
            if (!haset.add(s2)) {
                haset.remove(s2);
            }
            if (!haset.add(s3)) {
                haset.remove(s3);
            }
            if (!haset.add(s4)) {
                haset.remove(s4);
            }
        }
        if (!haset.contains(x1 + " " + y1) || !haset.contains(x1 + " " + y2) || !haset.contains(x2 + " " + y1)
                || !haset.contains(x2 + " " + y2) || haset.size() != 4) {
            return false;
        }
        return area == (x2 - x1) * (y2 - y1);
    }
}
