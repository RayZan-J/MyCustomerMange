package Action.LetCode;

import java.util.Arrays;

/**
 * Created by zll on 2017/9/29 0029.
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * <p></p>
 * 给定连个排好序的数组，m,n为两个数组个数，将第二个数组插入到第一个中，且是排好序的数组
 */
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        int[] num2 = {2};
        merge(nums, 1, num2, 1);
    }
}
