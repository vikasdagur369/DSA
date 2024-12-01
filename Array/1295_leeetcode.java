// approach 1
class Solution {

    public boolean numberHasEvenDigit(int num){
        int digitCount = 0;

        while (num != 0){
            num = num/10;
            digitCount++;
        }
        return digitCount % 2 == 0;
    }
    public int findNumbers(int[] nums) {
        //approach 1
        int evenCount = 0;
        for(int i=0; i<nums.length; i++){
            if(numberHasEvenDigit(nums[i])){
                evenCount++;
            }
        }

    return evenCount;
    }
}
// approach 2

class Solution {
 
    public int findNumbers(int[] nums) {
        
        int evenCount = 0;

        for(int num : nums ){
            int len = String.valueOf(num).length();

            if(len % 2 == 0){
                evenCount++;
            }
        }
    return evenCount;
    }
}

//Approach 3

class Solution {

    public int findNumbers(int[] nums) {

    int evenCount = 0;

    for(int num:nums) {
        if(num >= 10 && num <= 99 || num >=1000 && num <= 9999 || num == 100000){
            evenCount++;
        }
    }        
        return evenCount;

    }
}
