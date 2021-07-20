package Action.LetCode;

import java.util.*;

/**
 * Created by zll on 2017/8/31 0031.
 */
public class MajorityElement {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.get(nums[i]) != null) {
                map.put(nums[i], ++sum);
            } else {
                map.put(nums[i], sum = 1);
            }
        }
        if (nums.length > 3) {
            for (Integer n : map.values()) {
                if (n > nums.length / 3) {
                    list.add(n);
                }
            }
            Set set = map.entrySet();
            for (Object aSet : set) {
                Map.Entry entry = (Map.Entry) aSet;
                if (entry.getValue() == list.get(0)) {
                    list.set(0, (Integer) entry.getKey());
                }
                if (list.size() == 2) {
                    if (entry.getValue() == list.get(1)) {
                        list.set(1, (Integer) entry.getKey());
                    }
                }
            }
        } else {
            for (int i : nums) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 2, 3, 2};
        System.out.println(majorityElement(test).toString());
    }
}
