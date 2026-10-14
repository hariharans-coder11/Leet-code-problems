public class Solution {
    public boolean hasCycle(ListNode head) {
        // Base case: if the list is empty or has only one node without a cycle
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse until fast reaches the end of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Moves 1 step
            fast = fast.next.next;     // Moves 2 steps
            
            // If they meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }
        
        // If the loop finishes, fast reached null (no cycle)
        return false;
    }
}