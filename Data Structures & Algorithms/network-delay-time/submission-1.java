public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0],
            x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; i++) dist.put(i, Integer.MAX_VALUE);

        dfs(k, 0, adj, dist);
        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int node, int time,
                     Map<Integer, List<int[]>> adj,
                     Map<Integer, Integer> dist) {
        if (time >= dist.get(node)) return;
        dist.put(node, time);
        if (!adj.containsKey(node)) return;
        for (int[] edge : adj.get(node)) {
            dfs(edge[0], time + edge[1], adj, dist);
        }
    }
}