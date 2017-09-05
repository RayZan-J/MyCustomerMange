package Action.LetCode;

import java.util.Arrays;

/**
 * Created by zll on 2017/9/5 0005.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 �� 2
 [1,3,5,6], 2 �� 1
 [1,3,5,6], 7 �� 4
 [1,3,5,6], 0 �� 0
 �������и�������Ӧ�ڵ�λ�ã�����ֱ�ӷ���
 */
public class SearchInsert {
    //my lower solution
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }else if(nums[i]<target){
                if(i+1==nums.length){
                    return i+1;
                }
            }else{
                return i;
            }
        }
        return 0;
    }
    //α����
    public static int searchInsertOthers(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int mid = 0;
        while (low<high){
            mid = (low+high)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target<nums[mid]){
                high = high-1;
            }else {
                low=low+1;
            }
        }
        return (low+high)/2;
    }
    //���ֲ��ҷ�������м�ֵ���ˣ����λ-1��С�ˣ����λ+1��
    public static int searchInsertAnOthers(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 2;
        System.out.println(searchInsertOthers(nums,target));
    }
}
