package day_0330;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 242、202、290 205 451
 * 数组有序后，使用怎样的方式来解决此问题
 * @author aml
 * @date 2021/4/4 19:03
 */
public class A_08_350_两个数组的交集2 {

    /**
     * // 时间复杂度: O(nlogn)
     * // 空间复杂度: O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1){  //将nums1中的数，放入map中，k为数，v为频次
            if ( !map.containsKey(i) ){
                map.put(i,1);   //修改操作 时间是 logn 的时间复杂度
            }else {
                map.put(i,map.get(i)+1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int j : nums2){
            if (map.containsKey(j) && map.get(j) > 0){
                ans.add(j);
//                重点，将map中重复的k的频次--
                map.put(j,map.get(j)-1);
            }
        }

//        最后放入到int[]返回数组中
        int[] res = new int[ans.size()];
        for (int i = 0;i<ans.size();i++){
            res[i] = ans.get(i);
        }

        return res;
    }

//    输出查看
    public static void printArr(int[] arr){
        for (int e : arr){
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = intersect(nums1, nums2);


        printArr(res);
    }


}
