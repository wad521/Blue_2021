package 力扣_相似字符串组;

public class 并查集_Solution {
    public static void main(String[] args) {
        String[] strs = {"omv","ovm"};
        System.out.println(numSimilarGroups(strs));
    }

    public static int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        UnionFind uf = new UnionFind(n, strs);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(uf.find(i) == uf.find(j)){
                    continue;
                }
                if (check(strs[i], strs[j], m)) {
                        uf.union(i, j);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == i) {
                ret++;
            }
        }
        return ret;
    }

    public static boolean check(String a, String b, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                //即只能用两个位置字母不同，否则不符合
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}

class UnionFind {
    int[] f;

    public UnionFind(int n, String[] s) {
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
    }

    public boolean union(int i, int j) {
        int fi = find(i), fj = find(j);
        if (fi == fj) {
            return true;
        }
        f[fi] = fj;
        return false;
    }

    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }
}
