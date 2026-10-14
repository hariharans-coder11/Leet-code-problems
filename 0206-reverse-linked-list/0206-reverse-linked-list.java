class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next; // Store the next node
            current.next = prev;            // Reverse the current node's pointer
            prev = current;                 // Move prev one step forward
            current = nextTemp;             // Move current one step forward
        }
        
        return prev; // prev will be pointing to the new head
    }
}