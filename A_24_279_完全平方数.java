package day_0330;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * 127 126
 * @author aml
 * @date 2021/4/15 13:32
 */
public class A_24_279_完全平方数 {

    /** 广度优先遍历（队列） 图论（无权图）
     *  构建一个有向图
     * @param n
     * @return
     */
    public int numSquares(int n) {
        assert (n > 0 );

        Queue<Pair<Integer, Integer>> q  = new ArrayDeque<>();
        q.add(new Pair<>(n, 0 ));

        boolean[] vis = new boolean[n+1]; //
        vis[n] = true;

        while (!q.isEmpty()){
            Pair<Integer, Integer> fornt = q.poll();
            int num = fornt.getKey();
            int step = fornt.getValue();
//            返回
            if (num == 0){
                return  step;
            }

            for (int i = 1; num - i*i >= 0; i++ ){
                if (!vis[num -i*i]){
                    q.add(new Pair<>(num -i*i, step + 1));
                }

                vis[num - i*i] = true;
            }

        }

        throw new IllegalStateException("无解");
    }






    public static void main(String[] args) {

        System.out.println((new A_24_279_完全平方数()).numSquares(12));
        System.out.println((new A_24_279_完全平方数()).numSquares(13));
    }
}
