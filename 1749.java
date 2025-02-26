class Solution {
    public int maxAbsoluteSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
      int max = 0;
      int sum = 0;
      int negativeMax = 0;
      int positiveMax = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
    
        if (sum - negativeMax > max) {
            max = sum - negativeMax;
            positiveMax = sum;
        } else if (positiveMax - sum > max) {
            max = positiveMax - sum;
            negativeMax = sum;
        }
        
      }
      return max;
    }
 }
