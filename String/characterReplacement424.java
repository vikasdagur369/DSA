class Solution {
    public int characterReplacement(String s, int k) {
        // Create an array to track occurrences of characters.
        int[] occurance = new int[26]; // Size should be 26 for letters A-Z.
        int left = 0, right = 0;
        int ans = 0;
        int maxOccurance = 0;

        // Traverse the string with a sliding window.
        for (right = 0; right < s.length(); right++) {
            // Update the occurrence of the current character.
            maxOccurance = Math.max(maxOccurance, ++occurance[s.charAt(right) - 'A']);

            // If the window size minus the most frequent character exceeds k, shrink the window from the left.
            if (right - left + 1 - maxOccurance > k) {
                occurance[s.charAt(left) - 'A']--; // Decrement the count for the character at the left pointer.
                left++; // Move the left pointer to the right.
            }

            // Update the maximum length of the valid window.
            ans = Math.max(ans, right - left + 1);
        }
        
        // Return the maximum length found.
        return ans;
    }
}
