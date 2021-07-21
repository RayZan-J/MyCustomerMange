package Action.LetCode;

/**
 * 题目:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * <p>
 * 思考:最笨的办法,用map,将次数存起来,然后遍历map,得到次数为1的key,但是不满足O(n)
 *
 * @author zll
 * @since 2021-07-21 18:28
 */
public class FindOnly {
    /**
     * 原理:使用异或运算 ^
     * <p></p>
     * 异或运算有以下三个性质:
     * <p></p>
     * 1.任何数和 00 做异或运算，结果仍然是原来的数，即 a ^ 0=a,a ^ 0=a
     * <p></p>
     * 2.任何数和其自身做异或运算，结果是 00，即 a ^ a=0 ,a ^ a=0
     * <p></p>
     * 3.异或运算满足交换律和结合律，即 a ^ b ^ a=b ^ a ^ a=b ^ (a ^ a)=b ^ 0=b
     * <p></p>
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1, 2, 5, 3, 4};
        System.out.println(singleNumber(nums));

        int[] nums1 = {1, 2, 3, 4, 1, 2, 5, 3, 4, 6, 6};
        System.out.println(singleNumber(nums1));
    }
}
