class Solution {
    public int minOperations(int[] nums) {
        if(nums.length==3){
            if((nums[0]==0 && nums[1]==0 && nums[2]==0))
            {
                return 1;
            }
            if(nums[0]==1 && nums[1]==1 && nums[2]==1){
                return 0;
            }
            else{
                return -1;
            }
        }
        int l=0,r=2,ans=0;
        while(r<nums.length){
            if(nums[l]==1){
                l++;
            }
            else{
                ans++;
                nums[l]=1;
                if(nums[l+1]==0){
                    nums[l+1]=1;
                }else{
                    nums[l+1]=0;
                }
                if(nums[l+2]==0){
                    nums[l+2]=1;
                }else{
                    nums[l+2]=0;
                }
                l++;
            }
            r++;
        }
        boolean b=false;
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
            if(nums[i]==0){
                b=true;
                break;
            }
        }
        if(b || nums[nums.length-1]==0 ||  nums[nums.length-2]==0)
            return -1;
        return ans;
        
    }
}
