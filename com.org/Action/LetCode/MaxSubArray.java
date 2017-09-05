package Action.LetCode;

/**
 * Created by zll on 2017/9/5 0005.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 �ҳ�����������������Ϊ����
 */
//��n[i]+n[i+1]<n[i+1]ʱ����n[i+1]���¿�ʼ��͡�һֱ����������¼���м���ֹ�������
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int temp = nums[0];
        int maxnum = nums[0];
        for(int i=1;i<nums.length;i++){
            temp = Math.max(temp+nums[i],nums[i]);
            maxnum = Math.max(temp,maxnum);
        }
        return maxnum;

    }
}
