/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // PriorityQueue (min-heap) to store the values of nodes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through each list in the array of lists
        for(ListNode list : lists){
            // Traverse each node in the current list
            while(list != null){
                // Add the value of each node to the min-heap
                minHeap.add(list.val);
                // Move to the next node in the list
                list = list.next;
            }
        }

        // Dummy node to help in building the merged linked list
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;

        // Extract elements from the min-heap and build the new merged linked list
        while (!minHeap.isEmpty()){
            // Create a new node with the smallest value from the heap and link it to the merged list
            merge.next = new ListNode(minHeap.remove());
            // Move to the next node in the merged list
            merge = merge.next;
        }
        
        // Return the next node of dummy, which is the head of the merged list
        return dummy.next;
    }
}
