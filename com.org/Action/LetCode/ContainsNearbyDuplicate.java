package Action.LetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zll on 2017/9/27 0027.
 * �������и�����Χ���Ƿ������ͬ����
 */
public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k){
        //ѭ����set�з�ֵ�����ǰk��������ͬ����set.add����false��
        // �������k���������Ƴ����Ȳ����ֵ��������ֵ���룬���ж�add����ֵ
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;

    }

}
