package Action.LetCode;

import java.util.Arrays;

/**
 * Created by zll on 2017/9/4 0004.
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * <p>
 * 即：输出一个数组中3个数字相乘的最大值
 */
public class MaximumProduct {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int firstSum = nums[nums.length - 2] * nums[nums.length - 3];
        int endSum = nums[0] * nums[1];

        return (firstSum >= endSum ? firstSum : endSum) * nums[nums.length - 1];
    }

    //别人的答案，跟我思路差不多，不过精简好多
    public static int maximumProductOthers(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);

    }

    public static void main(String[] args) {
        int[] nums = {-4, -3, -2, -1, 60};
        System.out.println(maximumProduct(nums));
        System.out.println(maximumProductOthers(nums));
    }
}
