public class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int len) {
        parent = new int[len];
        rank = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty)
            return;
        if (rank[rootx] == rank[rooty]) {
            parent[rootx] = rooty;
            rank[rooty]++;
        } else if (rank[rootx] < rank[rooty]) {
            parent[rootx] = rooty;
        } else if (rank[rootx] > rank[rooty]) {
            parent[rooty] = rootx;
        }
    }
}
