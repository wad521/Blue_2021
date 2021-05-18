package 历届真题;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 和根植物 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m =input.nextInt();
        int n =input.nextInt();
        int len = m*n;
        UnionFind uf = new UnionFind(len);
        int s = input.nextInt();
        for (int i = 0; i < s; i++) {
            int x =input.nextInt();
            int y =input.nextInt();
            uf.union(x-1,y-1);
        }
        int result=0;
        for (int i = 0; i < len; i++) {
            if(uf.parent[i]==i){
                result++;
            }
        }
        System.out.println(result);
    }
}


class UnionFind {
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

