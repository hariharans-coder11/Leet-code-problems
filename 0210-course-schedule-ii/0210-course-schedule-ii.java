import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];
        
        // Build graph and calculate in-degrees
        // prerequisites[i] = [a_i, b_i] means b_i -> a_i
        for (int[] edge : prerequisites) {
            int dest = edge[0];
            int src = edge[1];
            graph.get(src).add(dest);
            inDegree[dest]++;
        }
        
        // Queue for courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] result = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[index++] = curr;
            
            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If we visited all courses, return the order; otherwise, there's a cycle
        return index == numCourses ? result : new int[0];
    }
}