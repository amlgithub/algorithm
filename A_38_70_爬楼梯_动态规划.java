package day_0330;

import java.util.Arrays;

/**120 64
 * @author aml
 * @date 2021/4/26 14:26
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class A_38_70_爬楼梯_动态规划 {

//    记忆化方法
    private int[] memo;

//递归
    private int calcWays(int n){
      if (n == 1){
          return 1;
      }
      if (n == 2){
          return 2;
      }
//记忆化方法
      if (memo[n] == -1){
          memo[n] = calcWays(n-1) + calcWays(n-2); //将递归结果 保存
      }

      return memo[n];
    }

    public int climbStairs(int n) {
        if (n < 0){
            throw new IllegalArgumentException("参数错误");
        }
        memo = new int[n+1];  // 记忆表
        Arrays.fill(memo,-1);

        return calcWays(n);
    }

//dp
    public int climbStairs2(int n) {
        if (n < 0){
            throw new IllegalArgumentException("参数错误");
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


    public static void main(String[] args) {

        System.out.println((new A_38_70_爬楼梯_动态规划()).climbStairs2(10));
    }
}
