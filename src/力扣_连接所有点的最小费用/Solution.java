package 力扣_连接所有点的最小费用;

import java.util.*;

public class Solution {
//    public static void main(String[] args) {
//        int[][] points = new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
//        int num = minCostConnectPoints(points);
//        System.out.println(num);
//    }

    public static int minCostConnectPoints(int[][] points) {
        int len = points.length;
        DisjointSetUnion up = new DisjointSetUnion(len);
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int l = dist(points, i, j);
                edges.add(new Edge(l, i, j));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len-o2.len;
            }
        });
//        for (Edge e : edges){
//            System.out.print("["+e.len+","+e.x+","+e.y+"] ,");
//        }
        System.out.println();
        int num = 0, result = 0;
        for (Edge edge : edges) {
            if (up.unionSet(edge.x, edge.y)) {
                result += edge.len;
                num++;
                if (num == len) {
                    return result;
                }
            }
        }
        return result;
    }

    public static int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}

class DisjointSetUnion {
    int[] parent;
    int[] rank;

    public DisjointSetUnion(int n) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean unionSet(int x, int y) {
        int FindX = find(x);
        int FindY = find(y);
        if (FindX == FindY) {
            return false;
        }
        //使FindY为根节点，即FindY>FindX
        if (rank[FindY] < rank[FindX]) {
            int temp = FindX;
            FindX = FindY;
            FindY = temp;
        }
        rank[FindY] += rank[FindX];
        parent[FindX] = FindY;
        return true;
    }
}

class Edge {
    int len, x, y;

    public Edge(int len, int x, int y) {
        this.len = len;
        this.x = x;
        this.y = y;
    }
}