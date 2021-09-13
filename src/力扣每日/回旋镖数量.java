package 力扣每日;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:yxl
 **/
public class 回旋镖数量 {
    public int numberOfBoomerangs(int[][] points) {
        int ans =0;
        for(int[] x : points){
            HashMap<Integer,Integer> map = new HashMap();
            for(int[] y : points){
                if(x[0]==y[0] && x[1]==y[1]) continue;
                int dic = (x[0]-y[0])*(x[0]-y[0]) + (x[1]-y[1])*(x[1]-y[1]);
                map.put(dic,map.getOrDefault(dic,0)+1);
            }

            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                int m = entry.getValue();
                ans += (m *(m-1));
            }
        }
        return ans;
    }
}
