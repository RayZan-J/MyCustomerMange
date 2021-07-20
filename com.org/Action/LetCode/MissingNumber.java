package Action.LetCode;

/**
 * Created by zll on 2017/9/4 0004.
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * 找出数组中缺失的数组，如果数组从0开始一直排序，则返回n+1；
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i : nums) {
            sum += i;
        }
        return n * (n + 1) / 2 - sum;
    }

    /**
     * 别人的方法，运用了n^n = 0，由于数组有0--n组成，则（0--n）^(0--n) = 0;由于下标从0开始，则需要最后^一个nums.length
     */
    public int missingNumberOthers(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ nums.length;
    }

}
