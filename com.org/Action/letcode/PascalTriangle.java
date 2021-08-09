package Action.letcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zll on 2017/9/18 0018.
 * 求帕斯卡三角给定行数的行
 */
public class PascalTriangle {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> temp;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            temp = new ArrayList<>();
            temp.add(0, 1);
            for (int j = 1; j < i; j++) {
                temp.add(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i > 0) {
                temp.add(i, 1);
            }
            result.add(temp);
        }
        return result.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(getRow(4).toString());
    }
}
