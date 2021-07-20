package Action.LetCode;

import java.util.Arrays;

/**
 * Created by zll on 2017/8/29 0029.
 * 如何将一个数组中的0向后排
 */
public class MoveZeroes {
    /**
     * 方法1:
     * {0, 1, 0, 3, 12,0,1,0} ==》{1,3,12,1,12,0,1,0}
     * {1,3,12,1,12,0,1,0} ==>{1, 3, 12, 1, 0, 0, 0, 0}
     *
     * @param nums
     * @return
     */
    public static int[] moveZeroes(int[] nums) {
        int lastnum = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[lastnum++] = n;
            }
        }
        while (lastnum != nums.length) {
            nums[lastnum++] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] test = {0, 1, 0, 3, 12, 0, 1, 0};
        System.out.println(Arrays.toString(moveZeroes(test)));
        System.out.println(Arrays.toString(moveZeroes1(test)));
    }

    /**
     * 方法2:
     * {0, 1, 0, 3, 12,0,1,0} ==》{1, 0, 0, 3, 12,0,1,0}==>{1, 3, 0, 0, 12,0,1,0}=>{1, 3, 12, 0, 0,0,1,0}
     * =>{1, 3, 12, 1, 0, 0, 0, 0}
     *
     * @param nums
     * @return
     */
    public static int[] moveZeroes1(int[] nums) {
        int temp = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n != 0) {
                temp = nums[j];
                nums[j] = n;
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }
}
