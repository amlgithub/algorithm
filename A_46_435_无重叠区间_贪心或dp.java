package day_0330;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aml
 * @date 2021/5/4 23:22
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠
输入: [ [1,2], [2,3], [3,4], [1,3] ]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */
public class A_46_435_无重叠区间_贪心或dp {
    /**
     * 使用贪心算法：（一般是使用最大或最小的，所以一般涉及排序问题）
     *      想要最多的无重叠区间，可以类比想要参加最多聚会，[star][end]：开始~结束时间
     *  分四步：
     *      1. 将二维数组按照end时间进行 升序排序，即按照arr[1]
     *      2. 找出end最小的区间 x
     *      3. 把与x相交的区间全都删除
     *      4. 重复上述23两步操作，直到intervals为空
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals == null || intervals.length <=0 )return 0;

//        1. 升序; 将intervals按照 intervals[1]进行升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
//      2. 第一个区间就是 x的区间， 统计与x区间相交的数量
        int count = 1; //
        int x_end = intervals[0][1];
//        只要x_end < 后面区间star就都删除， 即star>=end
        for (int[] y : intervals){
            int star = y[0];
            if (star >= x_end){
                count++;
                x_end = y[1];
            }
        }

        return intervals.length - count;
    }

}
