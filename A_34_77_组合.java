package day_0330;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**39 40 216 78 90 401
 * @author aml
 * @date 2021/4/25 13:59
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class A_34_77_组合 {

    private List<List<Integer>> res;
//递归+回溯
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        if (n<=0 || k<=0 || n <k){
            return res;
        }
        LinkedList<Integer> c = new LinkedList<>();
        generateCombinations(n,k,1,c);

        return res;
    }

//    求解C(n,k), 当前已经找到的组合存储在c中，需要从start开始搜索新的元素
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c) {
//        递归终止条件
        if (c.size() == k){
//            保存
            res.add((LinkedList<Integer>) c.clone());
            return;
        }

        for (int i=start; i<=n; i++){
            c.addLast(i);
            generateCombinations(n,k,i+1,c);
            c.removeLast();
        }

        return;
    }


//    递归剪枝操作
//    求解C(n,k), 当前已经找到的组合存储在c中，需要从start开始搜索新的元素
private void generateCombinations2(int n, int k, int start, LinkedList<Integer> c) {
//        递归终止条件
    if (c.size() == k){
//            保存
        res.add((LinkedList<Integer>) c.clone());
        return;
    }

//    剪枝，提供效率
//    还有k-c.size()个空位，所以，【i...n】中至少要有k-c.size个元素
//    i最多为n-(k-c.size) + 1  个
    for (int i=start; i<=n-(k-c.size()) + 1; i++){
        c.addLast(i);
        generateCombinations(n,k,i+1,c);
        c.removeLast();
    }

    return;
}


}
