class Solution {
    public int maxProfit(int[] prices) {
        
        // Initialize minprice to a very large value (infinity)
        // This will help in finding the minimum price in the array
        int minprice = Integer.MAX_VALUE;
        
        // Initialize maxprofit to 0
        // This will store the maximum profit that can be achieved
        int maxprofit = 0;
        
        // Loop through each price in the prices array
        for(int i = 0 ; i < prices.length ; i++){
            
            // If the current price is less than the minimum price found so far,
            // update the minimum price
            if(prices[i] < minprice){
                minprice = prices[i];
            }
            // If the current price minus the minimum price found so far is greater
            // than the maximum profit found so far, update the maximum profit
            else if(prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        
        // Return the maximum profit found
        return maxprofit;
    }
}
