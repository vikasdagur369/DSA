class Solution {
    public String getHappyString(int n, int k) {
        
        StringBuilder sb = new StringBuilder();

        get_ans(n, k, sb, ' ');

        return sb.toString();       

    }

    public void get_ans(int n, int k, StringBuilder ans, char lastChar){
        if(n == 0) return ;

        int range = (int)Math.pow(2, n-1);

        int lower = 1;
        int upper = range;

        for( char val = 'a'; val<='c'; val++){

            // System.out.println(range+" -- "+lower+" -- "+upper +" -- "+k);

            if( lastChar != val ){

                if(k>=lower && k<=upper){
                    ans.append(val);
                    n = n-1;
                    k = k - ( lower-1 );
                    get_ans(n, k , ans, val);
                    return ;
                }
                lower = upper + 1;
                upper = upper + range;
            }

        }
    }
}
