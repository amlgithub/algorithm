package day_0330;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**392
 *
 * @author aml
 * @date 2021/5/4 22:29
 *
假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。

对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

输入: g = [1,2], s = [1,2,3]
输出: 2
解释:
你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
你拥有的饼干数量和尺寸都足以让所有孩子满足。
所以你应该输出2

 */
public class A_45_455_分发饼干_贪心算法部分 {


//贪心算法一般涉及  最大最小的，因此需要是排好序的
    public int findContentChildren(int[] g, int[] s) {
            //int[]数组倒序，不能直接使用Collections，这个是针对Integer包装类的；
        //Comparator<Integer>也是针对包装类
//        Arrays.sort(g,Collections.reverseOrder());
        Arrays.sort(g);
        Arrays.sort(s);

        int gi=g.length-1, si =s.length-1; //指向数组末尾，即最大的
        int res = 0;
        while (gi>=0 && si>=0){
            if (s[si] >= g[gi]){
                res += 1;
                gi--;
                si--;
            }else {
                gi--;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int g1[] = {1, 2, 3};
        int s1[] = {1, 1};
        System.out.println((new A_45_455_分发饼干_贪心算法部分()).findContentChildren(g1, s1));

        int g2[] = {1, 2};
        int s2[] = {1, 2, 3};
        System.out.println((new A_45_455_分发饼干_贪心算法部分()).findContentChildren(g2, s2));
    }
}
