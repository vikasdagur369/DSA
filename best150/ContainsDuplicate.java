package best150;

import java.util.Arrays;
import java.util.HashSet;

//using HashSet in O(n)
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> h1= new HashSet<>();

        for(int num : nums){
            if(h1.contains(num)){
                return true;
            }
            h1.add(num);
        }
        return false;

    }
    public boolean ContainsDuplicate2(int[] nums){
        Arrays.sort(nums);

        for(int i=1; i<nums.length; i++){
            if (nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

}


