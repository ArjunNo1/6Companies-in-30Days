class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[numCourses];
        int[] deg = new int[numCourses];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < numCourses; ++i) {
            G[i] = new ArrayList<Integer>();
        }
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            deg[e[0]]++;
        }
        for (int i = 0; i < numCourses; ++i) {
            if (deg[i] == 0)
                bfs.add(i);
        }
        for (int i = 0; i < bfs.size(); ++i) {
            for (int j : G[bfs.get(i)]) {
                if (--deg[j] == 0) {
                    bfs.add(j);
                }
            }
        }
        return bfs.size() == numCourses;
    }
}