package Week4;

/**
 * @author: Lee
 * @version: v1.0
 * @package: Week4
 * @description: 被围绕的区域 leetcode 130
 * @date: 2021/10/31
 * @time: 4:05 下午
 * @link(https://leetcode-cn.com/problems/surrounded-regions/)
 */
public class SurroundedRegions {

    private int m, n;
    private int[] dx, dy;
    private char[][] board;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        dx = new int[]{-1, 0, 0, 1};
        dy = new int[]{0, -1, 1, 0};
        for (int i = 0; i <= m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int i = 0; i <= n; i++) {
            dfs(0, i);
            dfs(m - 1, i);
        }
        //遍历所有结点 如果还有为O的 转换X 为# 转换为O
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == 'O') {
                    board[i][j] = 'X';
                } else if (c == '#')
                    board[i][j] = 'O';


            }

    }

    void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') return;
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny);
        }
    }
}
