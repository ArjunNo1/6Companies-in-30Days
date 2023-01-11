
import java.util.*;
class Solution {
    public int countPaths(int n, int[][] roads) {
    final long MODULO = 1000000007;
    List<int[]>[] adj = new List[n];
    Arrays.setAll(adj, x -> new ArrayList<>());
    for (int[] r : roads) { // populate adjacency lists
        adj[r[0]].add(new int[]{r[1], r[2]});
        adj[r[1]].add(new int[]{r[0], r[2]});
    }
    long[] cost = new long[n], paths = new long[n];
    Arrays.fill(cost, -1); // -1 -> not visited
    Queue<long[]> q = new PriorityQueue<>((l, r) -> Long.compare(l[1], r[1])); // [node, cost]
    q.offer(new long[]{0,0});
    paths[0] = 1; // to make path accumulation work
    cost[0] = 0;
    
    while (!q.isEmpty()) {
        long[] f = q.poll();
        int fnode = (int) f[0];
        if (fnode == n - 1)
            return (int)(paths[fnode] % MODULO);
        for (int[] ch : adj[fnode]) {
            long newCost = f[1] + ch[1];
            if (newCost == cost[ch[0]]) // add all paths from the parent node
                paths[ch[0]] += paths[fnode] % MODULO;
            if (cost[ch[0]] == -1 || newCost < cost[ch[0]]) {
                paths[ch[0]] = paths[fnode]; // all previous paths are irrelevant
                q.offer(new long[]{ch[0], newCost});
                cost[ch[0]] = newCost;
            }
        }
    }
    return -1; // shouldn't get here
}
}