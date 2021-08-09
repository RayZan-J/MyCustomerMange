package Action.letcode;

import java.util.Arrays;

/**
 * Created by zll on 2017/9/13 0013.
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2
 *
 * 返回数组中除了给定数字外的数字个数，且能整出剩下的数组
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int n : nums) {
            if (n != val) {
                nums[i] = n;
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}
