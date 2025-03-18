class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 1;
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            int count=1;
            for(int j=i+1;j<nums.length;j++){
                if( (a & nums[j]) == 0){
                    count++;
                    a=a| nums[j]; // This steps or's all bit of all the previous nice subarray. and helps to check that the next one when anded then it will give 0 or not.  
                }
                else{
                    break;
                }
            }
            ans = Math.max(ans , count);
        }
        return ans;
    }
}
