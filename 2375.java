class Solution {
    public static String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n + 1; i++) sb.append(i);

        for(int i = 0; i < n; i++){
            int idx = i + 1;
            while(idx >= 1 && pattern.charAt(idx-1) == 'D' && sb.charAt(idx) > sb.charAt(idx-1)){
                char a = sb.charAt(idx);
                char b = sb.charAt(idx-1);
                sb.setCharAt(idx, b);
                sb.setCharAt(idx-1,a);
                idx--;
            }
        }

        return sb.toString();
    }
}
