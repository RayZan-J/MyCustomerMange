package Action.LetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zll on 2017/9/14 0014.
 */
public class Generate {
    public static List<List<Integer>> generate(int numRows) {
        List<Integer> list;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++){
            list = new ArrayList<Integer>();
            list.add(0, 1);
            for(int j=1;j<i;j++){
                list.add(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if(i!=0){
                list.add(i, 1);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(6).toString());
        List<Integer> list = new ArrayList<Integer>();
        list.add(0,1);
        list.add(0,2);
        System.out.println(list.toString());
    }
}
