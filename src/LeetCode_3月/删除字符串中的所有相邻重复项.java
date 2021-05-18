package LeetCode_3月;

import java.util.Stack;

/**
 * @author:yxl
 **/
public class 删除字符串中的所有相邻重复项 {
}

class Solution_ {
    public String removeDuplicates(String S) {
        StringBuffer st = new StringBuffer();
        int idx = -1;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (idx >= 0 && st.charAt(idx) == ch) {
                st.deleteCharAt(idx);
                idx--;
            }else {
                st.append(ch);
                idx++;
            }
        }
        return st.toString();
    }
}