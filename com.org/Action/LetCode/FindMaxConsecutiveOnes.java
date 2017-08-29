package Action.LetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zll on 2017/8/29 0029.
 * Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 简单来说就是给定给数组，求出数组中连续的1最多多少个，数组中只有0和1
 */
public class FindMaxConsecutiveOnes {
    //我的方法
    public static int findMaxConsecutiveOnes(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i:nums){
            sb.append(i);
        }
        String str = sb.toString();
        String[] temp = str.split("0");
        int maxnum = 0 ;
        for(String s:temp){
            int a = s.length();
            if(maxnum<=a){
                maxnum = a;
            }
        }
        return maxnum;
    }
    //高人的方法
    public static int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0;
        int maxhere = 0;
        for(int n:nums){
            max = Math.max(max,maxhere= n==0?0:maxhere+1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,1,0,1,1,1,0,1,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(a));
        System.out.println(findMaxConsecutiveOnes1(a));
    }
}
