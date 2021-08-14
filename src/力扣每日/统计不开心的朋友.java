package 力扣每日;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:yxl
 **/
public class 统计不开心的朋友 {
    public static void main(String[] args) {

    }

    static Map<Integer,Map<Integer,Integer>>  map = new HashMap<>();
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        //先将preferences转化成map   {x : { y , 得分},{z , 得分}......}
        //得分 = n - 排名  排名越前得分越高
        for (int i = 0; i < n; i++) {
            int[] p = preferences[i];
            Map<Integer,Integer> cur = new HashMap<>();
            for (int j = 0; j < n - 1 ; j++) {
                cur.put(p[j] , n - j);
            }
            map.put(i,cur);
        }

        int m = pairs.length;
        //保存结果
        int ans = 0;
        //遍历pairs(双重遍历)
        for (int i = 0; i < m; i++) {
            int x = pairs[i][0] , y = pairs[i][1];
            //xok，yok保证元素只被统计一次
            boolean xok = false , yok = false;
            for (int j = 0; j < m; j++) {
                //避免遍历到同一个区间
                if(i==j) continue;;
                int u = pairs[j][0] , v = pairs[j][1];
                //将<x,y>正向反向都进行一遍
                if(!xok && check(x,y,u,v) ){
                    xok = true;
                }
                if(!yok && check(y,x,u,v)){
                    yok = true;
                }
                //当x和y都确定位不开心 跳出
                if(xok && yok) break;
            }
            if(xok) ans++;
            if(yok) ans++;
        }
        return ans;
    }

    //<x , y>  <u , v>
    //若 x 与 u 的亲近程度胜过 x 与 y，且 u 与 x 的亲近程度胜过 u 与 v   x则不开心
    //即 xmap.get(u) > xmap.get(y) && umap.get(x) > umap.get(v)

    //<x ,y> <v , u>
    // xmap.get(v) > xmap.get(y) && vmap.get(x) > vmap.get(u)
    public static boolean check(int x,int y,int u ,int v){
        Map<Integer,Integer> xmap = map.get(x) , ymap = map.get(y) , umap = map.get(u) , vmap = map.get(v);
        if(xmap.get(u) > xmap.get(y) && umap.get(x) > umap.get(v)){
            return true;
        }
        if(xmap.get(v) > xmap.get(y) && vmap.get(x) > vmap.get(u)){
            return true;
        }
        return false;
    }
}
