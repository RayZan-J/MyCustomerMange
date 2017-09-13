package Action.LetCode;

/**
 * Created by zll on 2017/9/13 0013.
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence.

 Example 1:
 Input: [1,3,5,4,7]
 Output: 3
 Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 Example 2:
 Input: [2,2,2,2,2]
 Output: 1
 Explanation: The longest continuous increasing subsequence is [2], its length is 1.

 找出递增的最大个数
 */
public class FindLengthOfLCIS {
    //我的
    public static int findLengthOfLCIS(int[] nums) {
        int result;
        int increate= 1;
        int max = 1;
        if(nums.length!=0){
            for(int i = 0;i<nums.length-1;i++){
                result=nums[i+1]-nums[i];
                if(result>0){
                    ++increate;
                }else{
                    increate=1;
                }
                max = Math.max(increate,max);
            }
            return max;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] sums = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(sums));
    }

    //别人的
    public static int findAnthoner(int[] nums) {
        int res = 0, cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i-1] < nums[i]) res = Math.max(res, ++cnt);
            else cnt = 1;
        }
        return res;
    }

}


