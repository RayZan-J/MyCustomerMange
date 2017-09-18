package Action.LetCode;

/**
 * Created by zll on 2017/9/18 0018.
 * 计算给定数组，给定位数，连续最大值除给定位数的值
 */
public class FindMaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        int[] temp  = new int[k];
        int maxNum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-k+1;i++){
            System.arraycopy(nums,i,temp,0,k);
            int countNum=0;
            for(int j:temp){
                countNum+=j;
            }
            maxNum = Math.max(maxNum,countNum);
        }
        return (double)maxNum/k;
    }
    public static double findMaxAverageOthers(int[] nums, int k) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int temp = sum;
        //往后加一位，减去最前面一位
        for(int i=k;i<nums.length;i++){
            temp = temp+nums[i]-nums[i-k];
            sum = Math.max(temp,sum);
        }
        return (double)sum/k;
    }
}
