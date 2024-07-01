class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize sum to 0, which will store the current subarray sum
        int sum = 0;
        
        // Initialize max_sum to the first element of the array
        // This is because we need some initial value to compare with
        int max_sum = nums[0];

        // Loop through each element in the array
        for(int i = 0; i < nums.length; i++) {
            // Add the current element to the current subarray sum
            sum = sum + nums[i];

            // If the current subarray sum is greater than the max_sum, update max_sum
            if(sum > max_sum) {
                max_sum = sum;
            }

            // If the current subarray sum is less than 0, reset sum to 0
            // This is because a negative sum will decrease the value of any future subarray
            if(sum < 0) {
                sum = 0;
            }
        }

        // Return the maximum subarray sum found
        return max_sum;
    }
}
