import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Step 1: Build adjacency list for 1-indexed people
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // Color array: 0 = uncolored, 1 = group A, -1 = group B
        int[] color = new int[n + 1];
        
        // Check every component in case the graph is disconnected
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!bfsCheck(i, graph, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfsCheck(int start, List<List<Integer>> graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1; // Start with group 1
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int neighbor : graph.get(curr)) {
                // If the neighbor has the same color, bipartition is impossible
                if (color[neighbor] == color[curr]) {
                    return false;
                }
                // If uncolored, assign the opposite color and queue it
                if (color[neighbor] == 0) {
                    color[neighbor] = -color[curr];
                    queue.offer(neighbor);
                }
            }
        }
        
        return true;
    }
}