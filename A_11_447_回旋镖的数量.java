package day_0330;

import java.util.HashMap;
import java.util.Map;

/**
 * 149
 * @author aml
 * @date 2021/4/6 15:41
 */
public class A_11_447_回旋镖的数量 {

    /**
     * o(n^2)  o(n)
     * 找到枢纽点，获取其他点到枢纽点的距离
     * 使用一个查找表，查找和I(xi, yi)不同的数据
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i=0; i<points.length; i++){
//          存储点 i 到所有其他点的距离出现的频次
            Map<Integer,Integer> record = new HashMap<>();
            for (int j=0; j<points.length; j++){
                if (j != i){  //不是同一个点
//                    求离i点的距离，但是得考虑两个直接距离公式需要开方，则可能会导致有小数点，则，不开方使用
                    int dis = dis(points[i],points[j]);
                    if (record.containsKey(dis)){
                        record.put(dis,record.get(dis) + 1);
                    }else {
                        record.put(dis, 1);
                    }
                }
            }

//            整体遍历获取每个k多少种
            for (Integer dis : record.keySet()){
                res += record.get(dis) * (record.get(dis)-1);
            }

        }

        return res;
    }

//    两点之间的距离，不开方式
    private int dis(int[] pa, int[] pb) {
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
                (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((new A_11_447_回旋镖的数量()).numberOfBoomerangs(points));
    }
}
