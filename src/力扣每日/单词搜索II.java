package 力扣每日;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:yxl
 **/
public class 单词搜索II {

    TrieNode root = new TrieNode();

    class TrieNode {
        String s;
        TrieNode[] tire = new TrieNode[26];
    }

    void insert(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tire[u] == null) {
                p.tire[u] = new TrieNode();
            }
            p = p.tire[u];
        }
        p.s = s;
    }

    char[][] board;
    boolean[][] vis;
    int n, m;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Set<String> set = new HashSet<>();

    public List<String> findWords(char[][] _board, String[] words) {
        board = _board;
        m = board.length;
        n = board[0].length;
        vis = new boolean[m][n];
        for (String w : words) {
            insert(w);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int u = board[i][j] - 'a';
                if (root.tire[u] != null) {
                    vis[i][j] = true;
                    dfs(i, j, root.tire[u]);
                    vis[i][j] = false;
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (String s : set) {
            list.add(s);
        }
        return list;
    }

    void dfs(int i, int j, TrieNode node) {
        if (node.s != null) {
            set.add(node.s);
        }
        for (int[] d : dirs) {
            int dx = i + d[0], dy = j + d[1];
            if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
            if (vis[dx][dy]) continue;
            int u = board[dx][dy] - 'a';
            if (node.tire[u] != null) {
                vis[dx][dy] = true;
                dfs(dx, dy, node.tire[u]);
                vis[dx][dy] = false;
            }
        }
    }
}
