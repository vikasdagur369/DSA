package best150;

public class validAnagram242 {

    // rat , tar are valid anagram, means both the words have same letters, maybe their order can be diffrent

    public boolean isAnagram(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

        int[] charCount = new int[26];

        for(int i=0; i<s.length(); i++){

            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        for(int num:charCount){
            if(num !=0){
                return false;

            }
        }
        return true;
    }



}
