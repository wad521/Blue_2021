package Hot_100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:yxl
 **/
public class 无重复最长子字符串 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int right = -1;
        int result = 0;
        Set<Character> ck = new HashSet<Character>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                ck.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !ck.contains(s.charAt(right + 1))) {
                ck.add(s.charAt(right + 1));
                right++;
            }
            result = Math.max(result, right - i + 1);
        }
        return result;
    }
}

