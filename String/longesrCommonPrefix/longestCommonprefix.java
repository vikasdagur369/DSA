class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if the array is null or empty, return an empty string.
        if(strs == null || strs.length == 0) return "";

        // Start with the first string in the array as the initial prefix.
        String prefix = strs[0];

        // Compare the current prefix with each string in the array.
        for(int i = 1; i < strs.length; i++) {

            // Example: Suppose strs = {"flower", "flow", "flight"}
            // Initial prefix is "flower".

            // Narrow down the prefix with each comparison.
            while(strs[i].indexOf(prefix) != 0) {
                // If the current string does not start with the prefix,
                // shorten the prefix by one character from the end.
                
                // For strs[1] = "flow":
                // "flow".indexOf("flower") != 0, so prefix = "flowe"
                // "flow".indexOf("flowe") != 0, so prefix = "flow"
                // Now "flow".indexOf("flow") == 0, so prefix remains "flow".

                // For strs[2] = "flight":
                // "flight".indexOf("flow") != 0, so prefix = "flo"
                // "flight".indexOf("flo") != 0, so prefix = "fl"
                // Now "flight".indexOf("fl") == 0, so prefix remains "fl".
                
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, there is no common prefix.
                if(prefix.isEmpty()) return "";
            }
        }
        
        // After all comparisons, the longest common prefix is "fl".
        return prefix;
    }
}

  


