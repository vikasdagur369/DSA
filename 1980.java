class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        
        // Iterate through each string's diagonal element
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i); // Get the i-th character of the i-th string
            ans.append(curr == '0' ? '1' : '0'); // Flip '0' to '1' and '1' to '0'
        }
        
        return ans.toString(); // Return the unique binary string
    }
}
