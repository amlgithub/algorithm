package day_0330;

import java.util.Arrays;

/**322 377 474 139 494
 * @author aml
 * @date 2021/4/30 20:53
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 */
public class A_42_416_分割等和子集 {

//    ===================================================
    //记忆化搜索
//    memo[i][c] 表示使用索引为[0...i]的这些元素，是否可以完全填充一个容量为c的背包
//    -1表示未被计算； 0 表示不可以填充； 1 表示可以填充
    private int[][] memo;

    // 思路： 计算nums中所有数字和 sum， 取出一部分让其和== sum/2; 另一部分也为sum/2
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i=0; i < nums.length; i++){
            assert (nums[i] > 0 );
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }
        memo = new int[nums.length][sum/2+1];
        for (int i=0; i< nums.length; i++){
            for (int j=0; j< sum/2+1; j++){
                memo[i][j] = -1;
            }
        }
//        递归函数, 从0~len-1中，能否找到sum/2
        return tryPartition2(nums, nums.length - 1, sum/2);
    }

    //使用nums[0...index], 是否可以完全填充一个容量为sum的背包；  sum减小的方式递归
    private boolean tryPartition2(int[] nums, int index, int sum) {
        if (sum == 0){
            return true;
        }
        if (index < 0 || sum < 0){
            return false;
        }
        if (memo[index][sum] != -1){
            return memo[index][sum] == 1;
        }

        memo[index][sum] = (tryPartition2(nums, index-1,sum) ||
                                tryPartition2(nums, index-1, sum-nums[index]) ) ? 1 : 0;


        return memo[index][sum] == 1;
    }


//    ==================================================



//    **************************************************
    //dp
    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            assert (nums[i] >0);
            sum += nums[i];
        }
        if (sum %2 != 0){
            return false;
        }

        int n = nums.length;
        int C = sum / 2; //容量
        boolean[] dp = new boolean[C + 1];
        Arrays.fill(dp, false);

        for (int i=0; i<=C; i++){
            dp[i] = (nums[0] == i);
        }
        for (int i=1; i < n; i++) {
            for (int j =C; j>=nums[i]; j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[C];
    }



//    **************************************************

    //使用nums[0...index], 是否可以完全填充一个容量为sum的背包；  sum减小的方式递归
    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0){
            return true;
        }
        if (sum < 0 || index < 0 ){
            return false;
        }

        return tryPartition(nums, index-1,sum) ||
                tryPartition(nums, index-1, sum - nums[index]);

    }
// 思路： 计算nums中所有数字和 sum， 取出一部分让其和== sum/2; 另一部分也为sum/2
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i=0; i < nums.length; i++){
            assert (nums[i] > 0 );
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }
//        递归函数, 从0~len-1中，能否找到sum/2
       return tryPartition(nums, nums.length - 1, sum/2);
    }



    public static void main(String[] args) {

        int[] nums1 = {1, 5, 11, 5};
        printBool((new A_42_416_分割等和子集()).canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        printBool((new A_42_416_分割等和子集()).canPartition2(nums2));
    }



    private static void printBool(boolean res){
        System.out.println(res ? "True" : "False");
    }
}
