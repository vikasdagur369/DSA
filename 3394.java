class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        

        // since n can be 10^9 , finding all solution wont work , soritng will have to be done


        // first one the basis of x coordinates ; 
       // then on the basis of y coordinates 


       // then we will merge the overlapping internvas and if after overlapping the count of 
       // rectangle in rectangles array is more than 3 means it can be divided into three sbupart ; 



        Arrays.sort(rectangles , (a,b) -> (a[0] == b[0]) ? a[1]-b[1] : a[0]-b[0] ) ; 
         
         int count = 1 ; 
          

          int end = rectangles[0][2] ;



        for( int i = 1 ; i < rectangles.length; i++)
        {
           if( rectangles[i][0] < end)
           {
               end = Math.max(rectangles[i][2] , end) ; 

           }
           else
           {
            count++ ; 

            end = rectangles[i][2] ; 

           }
        }

        if(count >= 3)
        return true ; 

   

       // now to repeat same step to see can we do it verteically 


       Arrays.sort(rectangles , (a,b) -> (a[1] == b[1]) ? a[0]-b[0] : a[1]-b[1] ) ; 
         
        count = 1 ; 
          

           end = rectangles[0][3] ;



        for( int i = 1 ; i < rectangles.length; i++)
        {
           if( rectangles[i][1] < end)
           {
               end = Math.max(rectangles[i][3] , end) ; 

           }
           else
           {
            count++ ; 

            end = rectangles[i][3] ; 

           }
        }

        if(count >= 3)
        return true ; 


        return false ; 

    } 
}
