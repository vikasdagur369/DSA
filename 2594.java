class Solution {
    public long repairCars(int[] ranks, int cars) {
         int minRank = Integer.MAX_VALUE , maxRank= Integer.MIN_VALUE;
         Map<Integer,Integer> mp = new HashMap<>();

         for(int rank : ranks)
         {
            minRank = Math.min(rank,minRank);
            maxRank = Math.max(rank,maxRank);
           mp.put(rank,mp.getOrDefault(rank,0)+1);
         }

         //performing binary search with time 
         // min time = 1 && maxTime = 1 * cars * cars       we are using minRank * cars * cars because we want to minimize the result
         // if we wanted to maximize ther result we would have used maxRank * cars * cars
         long left = 1L;
         long right = 1L*minRank*cars*cars;

         while(left<right)
         {
            long mid = (left + right)/2;

            long repairCount=0;

            for(int rank = 1 ; rank <= maxRank ; rank++)
            {
                repairCount += mp.getOrDefault(rank,0)*(long) Math.sqrt(mid/rank);
            }

            if(repairCount >= cars)
            right = mid;
            else
            left = mid+1;
         }

         return left;

    }

}
