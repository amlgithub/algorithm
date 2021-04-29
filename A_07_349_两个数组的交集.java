package day_0330;

import java.util.HashSet;
import java.util.Set;

/**
 * @author aml
 * @date 2021/4/4 18:34
 */
public class A_07_349_两个数组的交集 {

    /**
     * // 时间复杂度: O(nlogn)
     * // 空间复杂度: O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums1){
            set.add(x);
        }
        Set<Integer> res = new HashSet<>();
        for (int y : nums2){
            if (set.contains(y)){
                res.add(y);
            }
        }

        int[] ans = new int[res.size()];
        int i = 0;
        for (int z : res){
            ans[i++] = z;
        }

        return ans;
    }

}
