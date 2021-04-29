package day_0330;

import java.util.HashMap;
import java.util.Map;

/**
 * 15 18 16
 * @author aml
 * @date 2021/4/6 14:08
 */
public class A_09_1_两数之和 {

    /**
     * o(n),o(n)
     * 使用双指针法，即对碰指针
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> record = new HashMap<>();
        int[] res = new int[2];
        for (int i=0;i<nums.length;i++){
//            查找target-nums[i] 元素
            int complement = target - nums[i];
            if (record.containsKey(complement)){ //判断再放入当前元素之nums[i]前时，是否找到target-nums[i]元素
                res = new int[]{i, record.get(complement)};
//                int[] res = {i, record.get(complement)};
                return res;
            }
//            如果没有找到，继续往下遍历
            record.put(nums[i],i);
        }
//如果遍历结束还没有找到，则报出异常信息
        throw new IllegalStateException("没有结果");

    }

    private static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {0,4,3,0};
        int target = 0;
        printArr(twoSum(nums, target));
    }
}
