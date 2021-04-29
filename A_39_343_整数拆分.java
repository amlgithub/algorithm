package day_0330;

import java.util.Arrays;

/**279 91 62 63
 * @author aml
 * @date 2021/4/26 20:21
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A_39_343_整数拆分 {

//    =====================
//    记忆化搜索
    private int[] memo;
    private int breakInteger2(int n){
        if (n == 1){
            return 1;
        }
        if (memo[n] != -1){
            return memo[n];
        }
        int res = -1;
        for (int i=1; i<n; i++){
            res = max3(res, i*(n-i), i*breakInteger2(n-i));
        }
        memo[n] = res;

        return res;
    }

    public int integerBreak2(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);

        return breakInteger2(n);
    }
//    =====================


//    ***************
//    dp方式
    public int integerBreak3(int n) {
//        dp[i]表示将数字i分割（至少分割成两部分）后得到的最大乘积
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<=n; i++){
//            求解dp[i]
            for (int j=1; j<=i-1; j++){
//                j + (i-j)
                dp[i] = max3(dp[i],j*(i-j), j*dp[i-j]);
            }
        }

        return dp[n];
    }


//    ***************



// 将n进行分割（至少分割两个部分）， 可以获得的最大乘积;   就是设置一个f(x)函数
    private int breakInteger(int n) {
        if (n == 1){
            return 1;
        }
        int res = -1;
        for (int i=1; i<= n-1; i++){
//          i + (n-i)
            res = max3(res, i*(n-i), i*breakInteger(n-i));
        }

        return res;
    }

//三个值进行比较大小
    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b,c));
    }

    public int integerBreak(int n) {
//        需要使用一个递归函数
        return breakInteger(n);
    }

    public static void main(String[] args) {

        System.out.println((new A_39_343_整数拆分()).integerBreak(2));
        System.out.println((new A_39_343_整数拆分()).integerBreak2(10));
        System.out.println((new A_39_343_整数拆分()).integerBreak3(10));
    }
}
