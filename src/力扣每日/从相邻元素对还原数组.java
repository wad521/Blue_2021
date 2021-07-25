package 力扣每日;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:yxl
 **/
public class 从相邻元素对还原数组 {
    static int N = (int) 1e6 + 10;
    static int[] q = new int[N];

    public static void main(String[] args) {
        int[][] adjacent = new int[][]{{2, 1}, {3, 4}, {3, 2}};

        int[] ans = restoreArray(adjacent);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }


    static int[] restoreArray(int[][] adjacentPairs) {
        //由于数对不重复，所以m个数对代表一共m+1个数
        int m = adjacentPairs.length;
        int n = m + 1;
        //构建相邻关系图
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adj : adjacentPairs) {
            int a = adj[0], b = adj[1];
            List<Integer> lista = map.getOrDefault(a, new ArrayList<>());
            lista.add(b);
            map.put(a, lista);
            List<Integer> listb = map.getOrDefault(b, new ArrayList<>());
            listb.add(a);
            map.put(b, listb);
        }
        //给定起始范围
        int l = N / 2;
        int r = l + 1;
        int start = adjacentPairs[0][0];
        List<Integer> list = map.get(start);
        //开始插入数字
        q[l--] = start;
        q[r++] = list.get(0);
        if (list.size() > 1) {
            q[l--] = list.get(1);
        }
        //全部插入时，长度为n
        while ((r - 1) - (l + 1) + 1 < n) {
            //用j暂时代替l或r的下标，放置l--或r++后，if语句判断的失误

            List<Integer> lista = map.get(q[l + 1]);
            int j =l ;
            for (int i : lista) {
                if (i != q[l + 2]) {
                    q[j--] = i;
                }
            }
            l =j;

            List<Integer> listb = map.get(q[r - 1]);
            j =r;
            for (int i : listb) {
                if (i != q[r - 2]) {
                    q[j++] = i;
                }
            }
            r =j ;
        }
//        for (int i = l+1 ; i < r; i++) {
//            System.out.print(q[i] + " ");
//        }
        //将有用的数字部分复制回ans
        int[] ans = new int[n];
        for (int i = l + 1, idx = 0; i < r; i++, idx++) {
            ans[idx] = q[i];
        }
        return ans;
    }
}
