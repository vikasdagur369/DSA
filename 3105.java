class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int inc=1;
        int dec=1;
        int result=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]+1<=nums[i+1]){
                inc++;
                result=Math.max(result,inc);
                dec=1;
            } else if (nums[i]-1>=nums[i+1]){
                dec++;
                result=Math.max(dec,result);
                inc=1;
            } else {
                inc=1;
                dec=1;
            }
        }
        return result;
    }
}
