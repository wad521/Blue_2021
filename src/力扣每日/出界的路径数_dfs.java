package 力扣每日;

/**
 * @author:yxl
 **/
public class 出界的路径数_dfs {
    static int mod = (int)1e9+7;
    static int m,n,max;
    //四个方向
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static int[][][] cache ;
    public int findPaths(int m1, int n1, int maxMove, int startRow, int startColumn) {
        m = m1;
        n = n1;
        max = maxMove;
        cache = new int[m][n][max+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= max ; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        int ans = dfs(startRow,startColumn,max);
        return ans;
    }

    public static int dfs(int x, int y, int k){
        if(x<0 || x>= m || y<0 || y>=n) return 1;
        if(k==0) return 0;
        if(cache[x][y][k]!= -1) return cache[x][y][k];
        int ans = 0;
        for(int[] d : dirs){
            int xx = x +d[0] ,yy = y+d[1];
            ans += dfs(xx,yy,k-1);
            ans %= mod;
        }
        cache[x][y][k] = ans;
        return ans;
    }
}

















