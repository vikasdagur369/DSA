class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        
        int len1= str1.length(),
        len2 = str2.length();

        int i=0,
        j=0;

        while(i<len1){
            if((str1.charAt(i) == str2.charAt(j)) ||
             (str1.charAt(i)+1 == str2.charAt(j)) ||
             (str1.charAt(i)=='z' && str2.charAt(j) == 'a' )){
                j = j+1;
                if(j == len2){
                    return true;
                }
             }
             i = i+1;
        }
        return j == len2;
    }
}
