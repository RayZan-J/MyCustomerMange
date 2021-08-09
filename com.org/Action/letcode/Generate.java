package Action.letcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zll on 2017/9/14 0014.
 * <p></p>
 * 帕斯卡三角
 * <p></p>
 * [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1],
 * [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1],
 * [1, 6, 15, 20, 15, 6, 1],
 * [1, 7, 21, 35, 35, 21, 7, 1]
 * <p>
 * 数字有规律：如 [1, 7, 21, 35, 35, 21, 7, 1]：
 * 7=1*7/1；
 * 21 = 7*（7-1）/（1+1）
 * 35 = 21*（7-2）/（2+1）
 * 35 = 35*（7-3）/（3+1）
 * 21 = 35*（7-4）/（4+1）
 * 7 = 21*（7-5）/（5+1）；
 * 1 = 7*（7-6）/（6+1）；
 */
public class Generate {
    public static List<List<Integer>> generateAnother(int numRows) {
        List<Integer> list;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            int prev = 1;
            list = new ArrayList<Integer>();
            list.add(prev);
            for (int j = 0; j < i; j++) {
                prev = prev * (i - j) / (j + 1);
                list.add(prev);
            }
            result.add(list);
        }
        return result;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<Integer> list;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            list = new ArrayList<Integer>();
            list.add(0, 1);
            for (int j = 1; j < i; j++) {
                list.add(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i != 0) {
                list.add(i, 1);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(6).toString());
        System.out.println(generateAnother(6).toString());
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(0,1);
//        list.add(0,2);
//        System.out.println(list.toString());
    }
}
