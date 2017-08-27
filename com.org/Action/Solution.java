package Action;

import java.util.Arrays;

/**
 * Created by zll on 2017/8/27 0027.
 * Given an array of 2n integers, your task is to group
 * these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn)
 * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

 Example 1:
 Input: [1,4,3,2]

 Output: 4
 Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 */
public class Solution {
    public static void main(String[] args) {
        int[] a = {1,2,3,6,4,9,7,13};
        int result = arrayPairSum(a);
        System.out.println(result);
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i=0;i<nums.length;i+=2){
            result+=nums[i];
        }
        return result;
    }
}
