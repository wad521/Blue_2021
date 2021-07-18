package 面试题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:yxl
 **/
public class 变位词组 {
    public static void main(String[] args) {
        String[] strs = new String[]{"abc","cba","acb","bbb","ccc"};
        List<List<String>> ans = groupAnagrams(strs);
        System.out.println(ans);
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] num = new int[26];
            for(char c : s.toCharArray()){
                num[c-'a']++;
            }
            StringBuffer key = new StringBuffer();
            for(int i :num){
                key.append(i+"+");
            }
            List<String>  list = map.getOrDefault(key.toString(),new ArrayList<>());
            list.add(s);
            map.put(key.toString(),list);
        }
        for (String key : map.keySet()) ans.add(map.get(key));

        return ans;
    }
}
