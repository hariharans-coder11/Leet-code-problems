import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // If the start or end cell is blocked, no path is possible
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        
        // 8 possible directions for movement (horizontal, vertical, and diagonal)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        
        Queue<int[]> queue = new LinkedList<>();
        // Store coordinates and the path length: {row, col, distance}
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1; // Mark the start cell as visited
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int distance = curr[2];
            
            // If we reach the bottom-right corner, return the path length
            if (r == n - 1 && c == n - 1) {
                return distance;
            }
            
            // Explore all 8 adjacent directions
            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                
                // Check bounds and ensure the cell is clear (0)
                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && grid[nextR][nextC] == 0) {
                    queue.offer(new int[]{nextR, nextC, distance + 1});
                    grid[nextR][nextC] = 1; // Mark as visited
                }
            }
        }
        
        // If the queue is exhausted without reaching the destination
        return -1;
    }
}