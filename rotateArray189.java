class Solution {
    public void rotate(int[] nums, int k) {
        // Ensure k is within the bounds of the array length
        k = k % nums.length;
        int n = nums.length;
        
        // Step 1: Reverse the entire array
        reverseNum(nums, 0, n - 1);
        
        // Step 2: Reverse the first part of the array (from 0 to k-1)
        reverseNum(nums, 0, k - 1);
        
        // Step 3: Reverse the second part of the array (from k to n-1)
        reverseNum(nums, k, n - 1);
    }

    public void reverseNum(int[] nums, int start, int end) {
        // Reverse the elements in the array from index start to index end
        while (start < end) {
            int temp = nums[start];  // Store the value at the start index
            nums[start] = nums[end]; // Swap the value at the end index to the start index
            nums[end] = temp;        // Place the stored value at the end index
            start++;                 // Move start index forward
            end--;                   // Move end index backward
        }
    }
}
