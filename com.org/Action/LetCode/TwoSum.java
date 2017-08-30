package Action.LetCode;

import java.util.Arrays;

/**
 * Created by zll on 2017/8/30 0030.
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 既给定一个有序数组，和一个值，求数组中第几个与第几个值相加等于该值
 */
public class TwoSum{
    public static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int max = numbers.length-1;
        while (low<max){
            int sum = numbers[low]+numbers[max];
            if(sum==target){
                return new int[]{++low, ++max};
            }else if(sum<target){
                low++;
            }else max--;
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,4,9,56,90};
        int target = 8;
        System.out.println(Arrays.toString(twoSum(a,target)));
    }
}
