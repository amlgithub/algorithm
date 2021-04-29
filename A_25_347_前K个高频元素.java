package day_0330;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 23 
 * @author aml
 * @date 2021/4/16 20:52
 */
public class A_25_347_前K个高频元素 {

    private class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            if ( !o1.getKey().equals(o2.getKey()) ){
                return o1.getKey() - o2.getKey();
            }
            return  o1.getValue() - o2.getValue();
        }
    }


    public int[] topKFrequent(int[] nums, int k) {
        if (k <= 0){
            throw new IllegalArgumentException(" 参数无效");
        }
//统计频次
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            if (freq.containsKey(nums[i])){
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }else {
                freq.put(nums[i], 1);
            }
        }

        if(k > freq.size())
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");

        // 扫描freq,维护当前出现频率最高的k个元素
        // 在优先队列中,按照频率排序,所以数据对是 (频率,元素) 的形式
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new PairComparator());
        for (Integer num : freq.keySet()){
            int numFreq = freq.get(num);
            if (pq.size() == k){
                if (numFreq > pq.peek().getKey()){
                    pq.poll();
                    pq.add(new Pair<>(numFreq,num));
                }
            }else {
                pq.add(new Pair<>(numFreq,num));
            }

        }


        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] ans = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()){
            //            res.add(pq.poll().getValue());
            int value = pq.poll().getValue();

            ans[i] = value;
            i = i+1;
//            System.out.println(i);
        }


        return ans;

    }


    private static void printList(int[] nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new A_25_347_前K个高频元素()).topKFrequent(nums, k));
    }
}
