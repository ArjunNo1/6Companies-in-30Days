class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<Integer>[] graph = new ArrayList[amount.length];
        for (int i = 0; i < amount.length; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return helper_dfs(graph, 0, bob, amount, new boolean[amount.length], 1)[0];
    }

    private int[] helper_dfs(List<Integer>[] graph, int node, int bob, int[] amount, boolean[] seen, int height) {
        int res = Integer.MIN_VALUE;
        seen[node] = true;

        int bobPathLen = node == bob ? 1 : 0;

        for (int nextNode : graph[node]) {
            if (seen[nextNode] == true)
                continue;
            int[] tmp = helper_dfs(graph, nextNode, bob, amount, seen, height + 1);
            if (tmp[1] > 0)
                bobPathLen = tmp[1] + 1;
            res = Math.max(res, tmp[0]);
        }

        if (bobPathLen > 0 && bobPathLen <= height) {
            if (bobPathLen == height)
                amount[node] = amount[node] / 2;
            else
                amount[node] = 0;
        }

        return new int[] { res == Integer.MIN_VALUE ? amount[node] : amount[node] + res, bobPathLen };
    }
}
