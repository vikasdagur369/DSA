class Solution {
    public void reorderList(ListNode head) {

        // If the list is empty, no need to reorder
        if(head == null){
            return;
        }
        
        // Find the middle of the linked list using slow and fast pointers
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list starting from the middle
        ListNode prev = null, curr = slow, temp;
        while(curr != null){
            temp = curr.next; // temporarily store the next node
            curr.next = prev; // reverse the current node's pointer
            prev = curr;      // move prev and curr one step forward
            curr = temp;  
        }

        // Merge the two halves
        ListNode first = head, second = prev;
        while(second.next != null){
            temp = first.next;  // temporarily store the next node of first half
            first.next = second; // link the current node of first half to the current node of second half
            first = temp;       // move the pointer of first half forward

            temp = second.next; // temporarily store the next node of second half
            second.next = first; // link the current node of second half to the current node of first half
            second = temp;       // move the pointer of second half forward
        }
    }
}
