package day_0330;

import java.util.HashMap;
import java.util.Map;

/**
 * 49
 * @author aml
 * @date 2021/4/6 14:47
 */
public class A_10_454_四数相加II {

    /**
     * 0(n^2)  0(n^2)
     * 1. 先将c+d的组合放入到查找表
     * 2. 再从a+b的组合中找相反的结果，
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> record = new HashMap<>(); //k:c+d的和，v:对应的频次
        for (int i=0; i<C.length; i++){
            for (int j=0; j<D.length; j++){
                if (record.containsKey(C[i]+D[j])){
                    record.put(C[i]+D[j], record.get(C[i]+D[j]) + 1);
                }else {
                    record.put(C[i]+D[j], 1);
                }
            }
        }

        //遍历A和B，查找对应-(A+B)的和
        int res = 0;
        for (int i=0; i<A.length; i++){
            for (int j=0; j<B.length; j++){
                if (record.containsKey(-A[i]-B[j])){
                    res += record.get(-A[i]-B[j]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println(fourSumCount(a, b, c, d));
    }
}
