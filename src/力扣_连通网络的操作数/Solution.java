package 力扣_连通网络的操作数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        int n = 6;
        System.out.println(makeConnected(n, connections));
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] s : connections) {
            uf.union(s[0], s[1]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (uf.connected(i, i)) {
                result += 1;
            }
        }
        return result-1;
    }
}

// 并查集模板
class UnionFind {
    int[] partent;
    int[] size;

    public UnionFind(int n) {
        size = new int[n];
        partent = new int[n];
        for (int i = 0; i < n; i++) {
            partent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x != partent[x]) {
            partent[x] = find(partent[x]);
        }
        return partent[x];
    }

    public boolean union(int x, int y) {
        int find_x = find(x);
        int find_y = find(y);
        if (find_x == find_y) {
            return false;
        }
        if (size[find_x] > size[find_y]) {
            int temp = find_x;
            find_x = find_y;
            find_y = temp;
        }
        partent[find_x] = find_y;
        size[find_y] += size[find_x];
        return true;
    }

    public boolean connected(int x, int y) {
        return find(x) == y;
    }
}