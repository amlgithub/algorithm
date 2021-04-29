package day_0330;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author aml
 * @date 2021/4/7 14:07
 */
public class A_13_220_存在重复元素III {

    /**
     * o(nlogn)  o(k)
     * 滑动窗口+查找表
     * floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
     * ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 这个问题的测试数据在使用int进行加减运算时会溢出
        // 所以使用long long
        TreeSet<Long> record = new TreeSet<>(); //ceiling 只有treeset（有序集合）中有，
        for (int i=0; i<nums.length; i++){
            if (record.ceiling((long)nums[i] - (long)t) != null
            && record.ceiling((long)nums[i] -(long)t) <= (long)nums[i] + (long)t){
                return true;
            }else {
                record.add((long)nums[i]);
            }

            if (record.size() == k+1){ //并且需要维持窗口大小为k
                record.remove((long)nums[i-k]);
            }
        }

        return false;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {2147483640,2147483641};
        int k = 1;
        int t = 100;
        printBool((new A_13_220_存在重复元素III()).containsNearbyAlmostDuplicate(nums, k, t));
    }
}
