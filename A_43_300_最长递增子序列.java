package day_0330;

import java.util.Arrays;

//https://github.com/liuyubobobo/Play-Leetcode/blob/master/0001-0500/0300-Longest-Increasing-Subsequence/java-0300/src/Solution1.java
// 官网GitHub递归操作
/**376
 * @author aml
 * @date 2021/5/2 11:02
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class A_43_300_最长递增子序列 {
//************************************************
    //记忆化搜索
    private int[] memo;
    //    =======================================================
    // 递归，f(x)：从以index（y）为结尾的函数中，获取最大值的递增子序列长度
    private int getMaxLength(int[] nums, int index){
        // 递归终止条件
        if (index < 0){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }
        int res = 1;
        for (int i=0; i<index; i++){
            if (nums[index] > nums[i]){
                res = Math.max(res, 1+getMaxLength(nums, i));
            }
        }
        return memo[index] = res;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int res = 1;
        for (int i=0; i<nums.length; i++){
            res = Math.max(res,getMaxLength(nums,i) ); //以i为结尾获取递增子序列
        }

        return res;
    }



//    =======================================================

//dp方法
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i=0; i< nums.length; i++ ){ //初始遍历
            for (int j=0; j < i; j++){  //遍历比i小的，以j结尾的
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int res = 1;
        for (int i=1; i< nums.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {

//        int nums1[] = {10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println((new A_43_300_最长递增子序列()).lengthOfLIS(nums1));
//        // 4
//
//        // ---
//
//        int nums2[] = {4, 10, 4, 3, 8, 9};
//        System.out.println((new A_43_300_最长递增子序列()).lengthOfLIS(nums2));
//        // 3
//
//        // ---
//
//        int nums3[] = {2, 2};
//        System.out.println((new A_43_300_最长递增子序列()).lengthOfLIS(nums3));
//        System.out.println((new A_43_300_最长递增子序列()).lengthOfLIS2(nums3));
//        // 1
//
//        // ---

        int nums4[] = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println((new A_43_300_最长递增子序列()).lengthOfLIS(nums4));
        System.out.println((new A_43_300_最长递增子序列()).lengthOfLIS2(nums4));

        // 6
    }
}
