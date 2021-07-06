package 力扣每日;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

/**
 * @author:yxl
 **/
class Solution_7_6 {
    public List<List<String>> displayTable(List<List<String>> os) {
        List<List<String>> ans = new ArrayList<>();
        // 桌号 : {餐品 : 个数}（用于构造内容）
        Map<Integer, Map<String, Integer>> tm = new HashMap<>();
        // 餐品（用于构造 title）
        Set<String> ts = new HashSet<>();
        for (List<String> o : os) {
            String c = o.get(0), t = o.get(1), f = o.get(2);
            Integer tidx = Integer.parseInt(t);
            ts.add(f);
            Map<String, Integer> map = tm.getOrDefault(tidx, new HashMap<>());
            map.put(f, map.getOrDefault(f, 0) + 1);
            tm.put(tidx, map);
        }
        int n = tm.size() + 1, m = ts.size() + 1;
        // 构造 title & 手动排序
        List<String> foods = new ArrayList<>(ts);
        Collections.sort(foods);
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(foods);
        ans.add(title);
        // 构造内容 & 手动排序
        List<Integer> tables = new ArrayList<>(tm.keySet());
        Collections.sort(tables);
        for (int tidx : tables) {
            Map<String, Integer> map = tm.get(tidx);
            List<String> cur = new ArrayList<>();
            cur.add(tidx + "");
            for (String food : foods) {
                cur.add(map.getOrDefault(food, 0) + "");
            }
            ans.add(cur);
        }
        return ans;
    }
}
