import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Build the adjacency list: node -> list of Node(neighbor, probability)
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            
            graph.get(u).add(new Node(v, prob));
            graph.get(v).add(new Node(u, prob)); // Undirected graph
        }
        
        // Max-Priority Queue ordered by highest probability first
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Node(start_node, 1.0));
        
        // Track the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.vertex;
            double currProb = curr.prob;
            
            if (u == end_node) {
                return currProb;
            }
            
            if (currProb < maxProb[u]) {
                continue;
            }
            
            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                double edgeProb = neighbor.prob;
                double newProb = currProb * edgeProb;
                
                if (newProb > maxProb[v]) {
                    maxProb[v] = newProb;
                    pq.offer(new Node(v, newProb));
                }
            }
        }
        
        return 0.0;
    }
    
    class Node {
        int vertex;
        double prob;
        
        Node(int vertex, double prob) {
            this.vertex = vertex;
            this.prob = prob;
        }
    }
}