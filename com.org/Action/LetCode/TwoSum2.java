package Action.LetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zll on 2017/9/26 0026.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 与之前的数组求和不同，这个数组没有排序，且有重复
 */
public class TwoSum2 {
    //我的方法，参考了排序数组，求和的方法
    public static int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<Integer>();
        for(int n:nums){
            list.add(n);
        }
        Arrays.sort(nums);
        int low = 0;
        int max = nums.length-1;
        while(low<=max){
            int sum = nums[low]+nums[max];
            if(sum==target){
                return new int[]{list.indexOf(nums[low]),list.lastIndexOf(nums[max])};
            }else if(sum<target){
                ++low;
            }else{
                --max;
            }
        }
        return new int[]{0,0};

    }
    public static int[] twoSumOthers(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("no such two element find");

    }
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSumOthers(nums, target)));
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
