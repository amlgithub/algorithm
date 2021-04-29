package day_0330;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author aml
 * @date 2021/4/25 16:35
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A_37_51_N皇后_经典递归回溯问题 {

//    n皇后，列判断、左对角线、右对角线判断
    private boolean[] col; //列
    private boolean[] dia1; // 左对角线， 从右上角-> 左下角
    private boolean[] dia2; //右对角线
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1]; //对角线个数为  2*n - 1  个
        dia2 = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<>();
        putQueen(n,0,row);

        return res;
    }

//    尝试在一个n皇后问题中，摆放第index行的 皇后位置
    private void putQueen(int n, int index, LinkedList<Integer> row) {
//        递归终止
        if (index == n){
//            找到最后一行的 皇后
            res.add(generateBoard(n,row));
            return;
        }

        for (int i = 0; i <n; i++){
//            尝试将第index行的皇后摆放在第i行
            if (!col[i] && !dia1[index+i] && !dia2[index-i+n-1]) {
                row.addLast(i);
                col[i] = true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;
                putQueen(n,index+1, row);
//                回溯
                row.removeLast();
                col[i] = false;
                dia1[index+i] = false;
                dia2[index-i+n-1] = false;
            }
        }

        return;
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row) {
        ArrayList<String> board = new ArrayList<>();
        for (int i=0; i<n; i++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }



    private static void printBoard(List<String> board){
        for(String s: board)
            System.out.println(s);
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 80;
        List<List<String>> res = (new A_37_51_N皇后_经典递归回溯问题()).solveNQueens(n);
        for(List<String> board: res)
            printBoard(board);
    }
}
