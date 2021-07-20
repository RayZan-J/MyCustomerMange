package Action.LetCode;

import java.util.*;

/**
 * Created by zll on 2017/8/28 0028.
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * <p>
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * <p>
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * 其实大概意思就是给你一个二维数组，还有两个数字，将数组重新排列成r*c的数组，如果无法排列，则输出原数组
 */
public class Solution1 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        nums = matrixReshape(nums, 1, 4);
        System.out.println(Arrays.deepToString(nums));
        nums = matrixReshape1(nums, 1, 4);
        System.out.println(Arrays.deepToString(nums));
    }

    //我的方案，粗糙很多
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int sum = 0;
        List templist;
        List<Integer> num = new ArrayList<Integer>();
        for (int[] temp : nums) {
            sum += temp.length;
            for (int n : temp) {
                num.add(n);
            }
        }
        if (sum == r * c) {
            int[][] bound = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bound[i][j] = num.get(i * c + j);
                }
            }
            return bound;
        } else {
            return nums;
        }
    }

    //letcode上看到的，的确比我的好多了
    public static int[][] matrixReshape1(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length) {
            return nums;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int[] num : nums) {
            for (int aNum : num) {
                queue.add(aNum);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }
}
