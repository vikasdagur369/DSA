class Solution {
    // This method returns an array of two integers that are indices of the two numbers
    // in the array 'nums' that add up to the target value.
    public int[] twoSum(int[] nums, int target) {

        // Create a HashMap to store the numbers and their corresponding indices.
        // The key is the number, and the value is its index in the array.
        Map<Integer, Integer> map = new HashMap<>();

        // Loop through each number in the array 'nums'.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference between the target value and the current number.
            int diff = target - nums[i];

            // Check if the difference 'diff' is already in the map.
            // If it is, that means we have found the two numbers that add up to the target.
            if (map.containsKey(diff)) {
                // Return the indices of the two numbers as an array.
                // The first index is the value associated with 'diff' in the map,
                // and the second index is the current index 'i'.
                return new int[]{map.get(diff), i};
            }

            // If 'diff' is not in the map, store the current number and its index in the map.
            map.put(nums[i], i);
        }

        // If no two numbers add up to the target, return null.
        return null;
    }
}
