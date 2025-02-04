class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=0,S=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i==nums.length-1)
            break;
            if(!(nums[i]<nums[i+1])){
                S=Math.max(sum,S);
                sum=0;
            }
        }
        return Math.max(S,sum);
    }
}
