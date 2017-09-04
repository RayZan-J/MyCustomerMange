package Action.LetCode;

import java.util.Arrays;

/**
 * Created by zll on 2017/9/4 0004.
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24

 �������һ��������3��������˵����ֵ
 */
public class MaximumProduct {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int firstSum = nums[nums.length-2]*nums[nums.length-3];
        int endSum = nums[0]*nums[1];

        return (firstSum>=endSum?firstSum:endSum)*nums[nums.length-1];
    }
    //���˵Ĵ𰸣�����˼·��࣬��������ö�
    public static int maximumProductOthers(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);

    }
    public static void main(String[] args) {
        int[] nums = {-4,-3,-2,-1,60};
        System.out.println(maximumProduct(nums));
        System.out.println(maximumProductOthers(nums));
    }
}
