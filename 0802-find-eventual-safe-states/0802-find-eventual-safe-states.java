import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0: unvisited, 1: visiting, 2: safe
        List<Integer> safeNodes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, color)) {
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
    }
    
    private boolean dfs(int node, int[][] graph, int[] color) {
        // If the node is already visited, return true if safe, false if part of a cycle
        if (color[node] > 0) {
            return color[node] == 2;
        }
        
        // Mark as visiting (part of current recursion path)
        color[node] = 1;
        
        for (int neighbor : graph[node]) {
            // If a neighbor is currently visiting, we found a cycle
            if (color[neighbor] == 1) {
                return false;
            }
            // If a neighbor leads to an unsafe node
            if (color[neighbor] == 0 && !dfs(neighbor, graph, color)) {
                return false;
            }
        }
        
        // Mark as safe
        color[node] = 2;
        return true;
    }
}