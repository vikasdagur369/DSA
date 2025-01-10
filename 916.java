class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for(String word:words2){
             int[] freq = getcount(word);
             for(int i=0;i<26;i++){
                 maxFreq[i] = Math.max(maxFreq[i],freq[i]);
             }
        }
        List<String> ans = new ArrayList<>();
        for(String word:words1){
           int[] freq = getcount(word);
           boolean isuniversal = true;
           for(int i=0;i<26;i++){
               if(freq[i]<maxFreq[i]){
                  isuniversal = false;
                  break;             
              }
           }
           if(isuniversal){
           ans.add(word);
           }
        }
        return ans;
    }
    private int[] getcount(String s){
         int[] ans = new int[26];
         for(char c : s.toCharArray()){
            ans[c-'a']++;
         }
         return ans;
    }
};
