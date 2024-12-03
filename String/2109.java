class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        StringBuilder sb = new StringBuilder();

        int spaceIndex = 0;
        int n = s.length();
        int m = spaces.length;
         for(int StringIndex=0;StringIndex<n;StringIndex++){
            if(spaceIndex < m && spaces[spaceIndex] == StringIndex){
                sb.append(' ');
                spaceIndex++;
            }
            sb.append(s.charAt(StringIndex));         
        }
          return sb.toString();

    }
}
