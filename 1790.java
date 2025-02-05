class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char a='Z';
        char b='Z';
        int n=s1.length();
        
        for(int i=0;i<n;i++){
            if(s1.charAt(i)==s2.charAt(i)){
                continue;
            }
            else{
                if(a=='Z'){
                    a=s1.charAt(i);
                    b=s2.charAt(i);
                }
                else{
                    if(s1.charAt(i)!=b || s2.charAt(i)!=a){
                        return false;}
                    b='Z';
                }
            }
        }
                    
        if(b=='Z'){
            return true;}
        return false;
    }
}
