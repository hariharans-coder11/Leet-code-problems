import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1); // -1: uncolored, 0 and 1: the two alternating colors
        
        // Handle potentially disconnected graph components
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 0; // Start coloring the component with 0
                
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    
                    for (int neighbor : graph[curr]) {
                        if (colors[neighbor] == -1) {
                            // Assign the opposite color to the neighbor
                            colors[neighbor] = 1 - colors[curr];
                            queue.offer(neighbor);
                        } else if (colors[neighbor] == colors[curr]) {
                            // Conflict found: adjacent nodes share the same color
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}