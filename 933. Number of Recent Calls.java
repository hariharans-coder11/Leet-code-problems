import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        // Add current timestamp to queue
        queue.offer(t);
        
        // Remove all requests older than (t - 3000)
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        
        // The remaining elements fall in the range [t - 3000, t]
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
