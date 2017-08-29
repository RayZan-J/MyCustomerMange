package Action.LetCode;

import java.util.*;

/**
 * Created by zll on 2017/8/29 0029.
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 大概意思就是一个数组本来值为1到数组.length+1，现在找出哪些缺失了
 */
public class FindDisappearedNumbers {
    //我的方法
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            list.add(i+1);
        }
        list.removeAll(set);
        return list;
    }

    public static void main(String[] args) {
        int[] test = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(test));
        System.out.println(findDisappearedNumbers1(test));
    }
    //别人的方法
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i:nums){
            int var = Math.abs(i)-1;
            if(nums[var]>0){
                nums[var] = -nums[var];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}
