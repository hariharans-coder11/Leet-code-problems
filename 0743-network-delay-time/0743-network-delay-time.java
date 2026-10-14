import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build the adjacency list
        // Map from source -> List ofint[]{target, weight}
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
        
        // Step 2: Min-priority queue ordered by accumulated time: [node, time]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});
        
        // Step 3: Track minimum time to reach each node
        Map<Integer, Integer> dist = new HashMap<>();
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            
            // If we already found a shorter way to reach node u, skip
            if (dist.containsKey(u)) continue;
            dist.put(u, d);
            
            // If u has outgoing edges, process neighbors
            if (graph.containsKey(u)) {
                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int w = neighbor[1];
                    
                    if (!dist.containsKey(v)) {
                        pq.offer(new int[]{v, d + w});
                    }
                }
            }
        }
        
        // Step 4: Check if all n nodes received the signal
        if (dist.size() != n) {
            return -1;
        }
        
        // Return the maximum time taken for any node to receive the signal
        int maxTime = 0;
        for (int time : dist.values()) {
            maxTime = Math.max(maxTime, time);
        }
        
        return maxTime;
    }
}