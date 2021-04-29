package day_0330;

import java.util.HashSet;
import java.util.Set;

/**
 * 217
 * @author aml
 * @date 2021/4/7 9:53
 */
public class A_12_219_存在重复元素II {

    /**
     * o(nlogn) o(k)
     * set是二叉树，即时间复杂度为logn
     * 滑动窗口+查找表
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> record = new HashSet<>(); //设定长度为K的查找表
        for (int i=0; i<nums.length; i++){
            if (record.contains(nums[i])){
                return true;
            }else {
                record.add(nums[i]); // 找不到，则插入此元素，
            }
            if (record.size() == k+1){ //并且需要维持窗口大小为k
                record.remove(nums[i-k]);
            }
        }

        return false;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
        int k = 2;
        printBool((new A_12_219_存在重复元素II()).containsNearbyDuplicate(nums, k));
    }
}
