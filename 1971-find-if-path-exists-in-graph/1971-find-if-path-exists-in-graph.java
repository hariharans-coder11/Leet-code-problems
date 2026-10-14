import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // If source and destination are the same, a path trivially exists
        if (source == destination) {
            return true;
        }
        
        // Step 1: Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Step 2: Initialize BFS data structures
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(source);
        visited[source] = true;
        
        // Step 3: Traverse the graph
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            // If we hit the destination, return true
            if (curr == destination) {
                return true;
            }
            
            // Explore all neighbors
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        // If the queue is empty and destination was not reached
        return false;
    }
}