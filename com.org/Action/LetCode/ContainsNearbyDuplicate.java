package Action.LetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zll on 2017/9/27 0027.
 * 求数组中给定范围内是否存在相同数据
 */
public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //循环往set中放值，如果前k个中有相同，则set.add返回false，
        // 如果超过k，则依次移除最先插入的值，并将新值插入，并判断add返回值
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;

    }

}
