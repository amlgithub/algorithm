package day_0330;

import java.util.Arrays;

/**213 337 309
 * @author aml
 * @date 2021/4/27 9:36
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A_40_198_打家劫舍 {
//    递归函数fx，考虑抢劫nums[index...nums.length ) 这个范围的所有房子
    private int tryBob(int[] nums, int index){
        if (index >= nums.length){
            return 0;
        }

        int res = Integer.MIN_VALUE;
//        在此范围中进行逐步尝试，获取其中最大的结果
        for (int i = index; i< nums.length; i++){
            res = Math.max(res, nums[i] + tryBob(nums, i+2)) ;//进行每次尝试
        }

        return res;
    }
    public int rob(int[] nums) {
        assert (nums.length > 0);
        return tryBob(nums,0);
    }

//    =====================================
/*
    //memo, 记忆化搜索
    private int[] memo;   //memo[i]： 表示考虑抢劫nums[i...n)  所能获取的最大 收益
//    递归函数+ 记忆化优化
    private int tryBob2(int[] nums, int index){
        if (index >= nums.length){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index]; //进行判别和使用
        }
        int res = Integer.MIN_VALUE;
        for (int i=index; i<nums.length; i++){
          *//*  if (memo[i] == -1){
                res = Math.max(res, tryBob2(nums, index+2));
            }else {
                res = memo[i];
            }*//*

          res = Math.max(res, nums[i] + tryBob2(nums, i+2)); //获取  tryBob2(nums, i+2)
        }

        memo[index] = res;//进行存储

        return res;
    }

    public int rob2(int[] nums) {
        assert (nums.length > 0);
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryBob2(nums,0);
    }

 */


    /**
     * 记忆化搜索 优化步骤
     * 1. 先初始值，memo
     * 2. 递归终止条件，即使用直接存过的memo[index]
     * 3. 存储memo[index]
     */
    private int[] memo;
    private int tryRob(int[] nums, int index){
        if (index >= nums.length){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }
        int res = Integer.MIN_VALUE;
        for (int i=index; i<nums.length; i++){
            res = Math.max(res, nums[i] + tryRob(nums, i+2));
        }
        memo[index] = res;

        return res;
    }
    public int rob2(int[] nums) {
        assert (nums.length > 0);
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums,0);
    }

//    =====================================





//    ----------------------------
//dp
    public int rob3(int[] nums) {
        assert (nums.length > 0);
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
//        dp【i】 表示考虑抢劫nums[i...n-1] 所能获得的最大收益
//        从最小的情况，递推  最后的n的情况; 最小的函数f(n-1), 即【n-1...n-1】,即只有一个情况
        dp[n-1] = nums[n-1];
        for (int i=n-2; i>=0; i--){
//            求解dp[i]，的最大值， 从小开始进行递推
            for (int j=i; j<n; j++){
                dp[i] = Math.max(dp[i], nums[j] + (j+2 <n ?dp[j+2] : 0) );
            }

        }

        return dp[0];
    }

//    ----------------------------

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(new A_40_198_打家劫舍().rob(arr));
        System.out.println(new A_40_198_打家劫舍().rob2(arr));
        System.out.println(new A_40_198_打家劫舍().rob3(arr));

    }
}
