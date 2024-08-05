class Solution {
    // Function to reverse nodes of a linked list in groups of size k
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head; // Pointer to traverse the list
        ListNode ktail = null; // Tail of the previous reversed group
        ListNode newHead = null; // New head of the reversed list

        // Traverse the entire list
        while (ptr != null) {
            int count = 0;
            ptr = head; // Reset ptr to the current head

            // Check if there are at least k nodes remaining in the list
            while (count < k && ptr != null) {
                ptr = ptr.next; // Move ptr forward
                count++;
            }

            // If there are at least k nodes, reverse this part
            if (count == k) {
                // Reverse k nodes starting from head
                ListNode revHead = reverseLinkedList(head, k);

                // If this is the first reversed group, set newHead
                if (newHead == null) {
                    newHead = revHead;
                }

                // Connect the previous group's tail to the head of the current reversed group
                if (ktail != null) {
                    ktail.next = revHead;
                }

                // Update ktail to be the current group's original head
                ktail = head;
                // Move head to the start of the next group of k nodes
                head = ptr;
            }
        }

        // Attach any remaining nodes to the last group's tail
        if (ktail != null) {
            ktail.next = head;
        }

        // Return the new head if it exists, otherwise return the original head
        return newHead == null ? head : newHead;
    }

    // Helper function to reverse k nodes of the linked list
    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode newHead = null; // New head after reversing
        ListNode ptr = head; // Pointer to traverse the list

        // Reverse k nodes
        while (k > 0) {
            ListNode nextNode = ptr.next; // Store the next node
            ptr.next = newHead; // Reverse the current node's pointer
            newHead = ptr; // Move the new head to the current node
            ptr = nextNode; // Move ptr to the next node
            k--;
        }

        // Return the new head of the reversed list
        return newHead;
    }
}
