package day_0330;

import java.util.Arrays;

/**
 * @author aml
 * @date 2021/4/29 19:45
 */
public class A_41_41_01背包 {

//    ===================================================
    //记忆化搜索
    private int[][] memo; //f(w,c)函数，由这两个变量进行控制，初始值为n,c+1即， c+1: 【0...c】都可以获取
    //记忆化搜索+ 递归函数，f(w,c) 用【0...index】的物品， 填充容积为c的背包的最大价值
    private int bestValueTwo(int[] w, int[] v, int index, int c){
        if (index <0 || c <= 0){
            return 0;
        }
        if (memo[index][c] != 0){
            return memo[index][c];
        }

        int res = bestValue(w,v,index-1, c);
        if (c >= w[index]){
            res = Math.max(res, v[index] + bestValue(w,v,index-1, c-w[index]));
        }

        memo[index][c] = res;
        return res;
    }

    public int knapsack01Two(int[] w, int[] v, int C){

        int n = w.length;
        memo = new int[n][C+1];
        for (int i=0; i< n; i++){
            for (int j=0; j<=C; j++){
                memo[i][j] = -1;
            }

        }
        return bestValue(w,v,n-1,C);
    }
//    ===================================================




//    ----------------------------------------
    //dp
    public int knapsack01DP(int[] w, int[] v, int C){
        assert (w.length == v.length);
        int n = w.length;
        if (n == 0){
            return 0;
        }
        int[][] dp = new int[n][C+1];
//        初值
        for (int j=0; j<=C; j++){
//            考虑第0个物品，容量为j的情况下，初值多少
            dp[0][j] = (j >= w[0] ? v[0] : 0 );
        }

//        递推， 随着物品和容量不断扩增， 最大值为多少
        for (int i=1; i<n; i++){ //物品
            for (int j=0; j<=C; j++){ //容量
                dp[i][j] = dp[i-1][j]; // 不放入第i个物品
                if (j >= w[i]){
                    dp[i][j] = Math.max(dp[i][j] , v[i] + dp[i-1][j-w[i]] );//放入第i个物品
                }
            }
        }
        return dp[n-1][C];
    }


//    ------------------------------------------



    //递归函数，f(w,c) 用【0...index】的物品， 填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c){
        if (index <0 || c <= 0){
            return 0;
        }
        int res = bestValue(w,v,index-1, c);
        if (c >= w[index]){
            res = Math.max(res, v[index] + bestValue(w,v,index-1, c-w[index]));
        }

        return res;
    }

    /**
     *
     * @param w 每一件物品的重量w[i]
     * @param v 每一件物品的价值v[i]
     * @param C 背包容量C
     * @return
     */
    public int knapsack01(int[] w, int[] v, int C){

        int n = w.length;
        return bestValue(w,v,n-1,C);
    }

    public static void main(String[] args) {

        int n = 5, w = 5;                    //物品个数，背包容量
        int[] value = {6,10,12};     //各个物品的价值
        int[] weight = {1,2,3};    //各个物品的重量

        System.out.println(new A_41_41_01背包().knapsack01(weight,value,w));
        System.out.println(new A_41_41_01背包().knapsack01Two(weight,value,w));
        System.out.println(new A_41_41_01背包().knapsack01DP(weight,value,w));
    }
}
