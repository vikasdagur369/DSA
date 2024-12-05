class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        
        int n = word1.length();
        int m = word2.length();

        int min = Math.min(n, m);

        // Loop through the minimum length and merge characters alternately
        for (int k = 0; k < min; k++) {
            sb.append(word1.charAt(k));
            sb.append(word2.charAt(k));
        }

        // Append remaining characters from the longer word
        if (n > m) {
            sb.append(word1.substring(min));
        } else {
            sb.append(word2.substring(min));
        }

        return sb.toString(); // Return the merged string
    }
}
