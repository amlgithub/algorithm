package day_0330;

/**130 417
 * @author aml
 * @date 2021/4/25 15:44
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class A_36_200_岛屿数量_深度遍历 {

    private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};//四个方向
    private int m,n;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        m = grid.length;
        assert m > 0;
        n = grid[0].length;

        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        visited = new boolean[m][n];
        int res = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
// 从grid[x][y]的位置开始，进行floodfill
//    保证（x,y）合法，且grid[x][y]没有被访问过的
    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i=0; i<4; i++){
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx,newy) && !visited[newx][newy] && grid[newx][newy] == '1'){
                dfs(grid,newx,newy);
            }
        }
        return;
    }

    private boolean inArea(int x, int y) {
        return x >=0 && x<m && y>=0 && y<n;
    }

    public static void main(String[] args) {

        char grid1[][] = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println((new A_36_200_岛屿数量_深度遍历()).numIslands(grid1));
        // 1

        // ---

        char grid2[][] = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println((new A_36_200_岛屿数量_深度遍历()).numIslands(grid2));
        // 3
    }
}
