package day_0330;

/**
 * @author aml
 * @date 2021/4/25 14:51
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A_35_79_单词搜索 {

    private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}}; // 顺时针方向： 左上右下四个方向
    private int m,n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if(board == null || word == null)
            throw new IllegalArgumentException("board or word can not be null!");

        m = board.length;
        assert(m > 0);
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j< n; j++){
                if (searchWord(board,word,0,i,j)){
                    return true;
                }
            }
        }

        return false;
    }

    // 从board[startx][starty]开始, 寻找word[index...word.size())
    private boolean searchWord(char[][] board, String word, int index,
                               int startx, int starty){
        if (index == word.length() -1){
            return board[startx][starty] == word.charAt(index);
        }

        if (board[startx][starty] == word.charAt(index)){
            visited[startx][starty] = true;
//            从startx starty 出发向四个方向寻找
            for (int i=0; i < 4; i++){
                int newx = startx + d[i][0]; //x: y轴不动
                int newy = starty + d[i][1]; //y: x轴不动
//                需要判断新的xy是否在此平面上，是否曾经访问过
                if (inArea(newx,newy) && !visited[newx][newy] &&
                        searchWord(board,word,index+1,newx,newy)){
                    return true;
                }
            }
            visited[startx][starty] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x>=0 && x < m && y>=0 && y<n;
    }

    public static void main(String args[]){

        char[][] b1 = { {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};

        String words[] = {"ABCCED", "SEE", "ABCB" };
        for(int i = 0 ; i < words.length ; i ++)
            if((new A_35_79_单词搜索()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);

        // ---

        char[][] b2 = {{'A'}};
        if((new A_35_79_单词搜索()).exist(b2,"AB"))
            System.out.println("found AB");
        else
            System.out.println("can not found AB");
    }
}
