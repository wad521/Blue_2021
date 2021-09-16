package 力扣每日;

/**
 * @author:yxl
 **/
public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int m = board.length,n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean ans = check(board,vis,i,j,word,0);
                if(ans){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean check(char[][] board,boolean[][] vis,int i, int j,String word,int k){
        if(board[i][j]!=word.charAt(k)){
            return false;
        }else if(k == word.length()-1){
            return true;
        }

        vis[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for(int[] direction : directions){
            int newi = i+direction[0],newj = j +direction[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if(!vis[newi][newj]){
                    boolean flag = check(board,vis,newi,newj,word,k+1);
                    if(flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        vis[i][j] = false;
        return result;
    }
}
