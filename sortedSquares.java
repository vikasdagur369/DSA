class Solution {
    public int[] sortedSquares(int[] nums) {
        // Initialize two pointers: 'l' at the start and 'r' at the end of the array
        int l = 0;
        int r = nums.length - 1;

        // Initialize the result array with the same length as the input array
        int[] res = new int[nums.length];

        // Traverse the result array from the end to the beginning
        for (int i = nums.length - 1; i >= 0; i--) {
            // Compare the absolute values of the elements at 'l' and 'r'
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                // If the absolute value at 'l' is greater, square it and put it in the current position in 'res'
                res[i] = nums[l] * nums[l];
                // Move the 'l' pointer to the right
                l++;
            } else {
                // Otherwise, square the value at 'r' and put it in the current position in 'res'
                res[i] = nums[r] * nums[r];
                // Move the 'r' pointer to the left
                r--;
            }
        }
        // Return the result array
        return res;
    }
}
