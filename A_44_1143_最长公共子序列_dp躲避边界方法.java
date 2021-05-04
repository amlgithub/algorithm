package day_0330;

/**
 * @author aml
 * @date 2021/5/4 18:20
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
    输入：text1 = "abcde", text2 = "ace"
    输出：3
    解释：最长公共子序列是 "ace" ，它的长度为 3 。
 */
public class A_44_1143_最长公共子序列_dp躲避边界方法 {
//    记忆化搜索
    private int [][] memo;

//  递归求解 f(m,n)的最长公共子序列
    private int getMaxLCS(String text1, String text2, int m, int n) {
        if (m < 0 || n < 0){
            return 0;
        }
        if (memo[m][n] != -1){
            return memo[m][n];
        }

        int res = 0;
        if (text1.charAt(m) == text2.charAt(n)){
            res = 1 + getMaxLCS(text1,text2,m-1,n-1);
        }else {
            res = Math.max(getMaxLCS(text1,text2,m-1,n) , getMaxLCS(text1,text2,m,n-1) );
        }

        memo[m][n] = res;
        return res;
    }
//    主函数
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null){
            throw new IllegalArgumentException("不能为空");
        }
        int len1 = text1.length();
        int len2 = text2.length();
        assert (len1>0 && len2>0);
        memo = new int[len1][len2];
        for (int i=0; i<len1; i++){
            for (int j=0; j<len2; j++){
                memo[i][j] = -1;
            }
        }


//      “从后向前 ”递归判断
//        getMaxLCS(text1,text2,len1-1,len2-1);
       return getMaxLCS(text1,text2,len1-1,len2-1);
//        return getLCS(text1,text2);
    }
//通过memo[][]反向求解s1和s2的最长公共子序列
    private String getLCS(String s1, String s2){
        int m = s1.length() - 1;
        int n = s2.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (m>=0 && n>=0){
            if (s1.charAt(m) == s2.charAt(n)){
                ans = ans.insert(0,s1.charAt(m));
                m--;
                n--;
            }else if (m == 0){
                n--;
            }else if (n == 0){
                m--;
            }else {
//                if (memo[m-1][n] > memo[m][n-1]){
                if(memo[m-1][n] > memo[m][n-1]){
                    m--;
                }else {
                    n--;
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {

        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println((new A_44_1143_最长公共子序列_dp躲避边界方法()).longestCommonSubsequence(s1,s2));
        System.out.println((new A_44_1143_最长公共子序列_dp躲避边界方法()).longestCommonSubsequenceDP(s1,s2));
        System.out.println((new A_44_1143_最长公共子序列_dp躲避边界方法()).longestCommonSubsequenceDP2(s1,s2));

        s1 = "AAACCGTGAGTTATTCGTTCTAGAA";
        s2 = "CACCCCTAAGGTACCTTTGGTTC";
        System.out.println((new A_44_1143_最长公共子序列_dp躲避边界方法()).longestCommonSubsequence(s1,s2));
    }


//    ====================================================
//    dp求解
    public int longestCommonSubsequenceDP(String text1, String text2) {
        if (text1 == null || text2 == null){
            throw new IllegalArgumentException("不能为空");
        }
        int len1 = text1.length();
        int len2 = text2.length();
        assert (len1>0 );
        assert (len2>0);
        int[][] dp = new int[len1][len2];

// 对memo的第0行和第0列进行初始化
//        从text2取第一字符和 text1进行比较
        for (int j=0; j<len2; j++){
            if (text1.charAt(0) == text2.charAt(j)){
                for (int k=j; k<len2; k++){ //从j往后都是1
                    dp[0][k] = 1;
                }
                break;
            }
        }
        //        从text1取第一字符和 text2进行比较
        for (int i=0; i<len1; i++){
            if (text2.charAt(0) == text1.charAt(i)){
                for (int k =i; k<len1; k++){
                    dp[k][0] = 1;
                }
            }
        }
//递推过程, ij从1开始
        for (int i=1; i<len1; i++){
            for (int j=1; j<len2; j++){
                if (text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

//        return dp[len1-1][len2-1];

//        通过dp反向求解s1和s2的最长公共子序列
        StringBuilder ans = new StringBuilder();
        int m = text1.length()-1;
        int n = text2.length()-1;
        while (m>=0 && n>=0){
            if (text1.charAt(m) == text2.charAt(n)){
                ans.insert(0, text1.charAt(m));
                m--;
                n--;
            }else if (m == 0){
                n--;
            }else if (n == 0){
                m--;
            }else {
                if (dp[m-1][n] > dp[m][n-1]){
                    m--;
                }else {
                    n--;
                }
            }
        }
        System.err.println();
        System.err.println(ans.toString());


        return dp[len1-1][len2-1];
    }

//****************************************************************************
    //    dp求解，躲避边界条件方法
    public int longestCommonSubsequenceDP2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
//        dp是 (m+1)*(n+1)的动态规划表格
//        dp[i][j] 表示s1的前i个字符和s2的前j个字符的最长公共子序列的长度
//        其中dp[0][j] 表示s1取空字符串时， 和s2的前j个字符作比较
//        dp[i][0]  表示s2取空字符串时，  和s1的前i个字符作比较
//        所以， dp[0][j] 和 dp[i][0] 均取为0
//        因此，我们不需要对dp进行单独的边界条件处理  :)
        int[][] dp = new int[m+1][n+1];
//        递推过程
//        下面的i和j可以取到m和n
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

}
