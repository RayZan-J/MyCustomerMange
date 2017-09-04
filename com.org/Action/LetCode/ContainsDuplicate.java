package Action.LetCode;

import java.util.Arrays;

/**
 * Created by zll on 2017/9/4 0004.
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * 如果一个int数组中有重复数，则返回true

 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<2){
            return false;
        }
        boolean isSame;
        for(int i=0;i<nums.length-1;i++){
            isSame = ( nums[i] == nums[i+1]);
            if(isSame){
                return true;
            }
        }
        return false;
    }
}
