package LeetCode_3月;

import java.util.*;

/**
 * @author:yxl
 **/
public class 计算器_全功能 {
}


class Solution_计算器 {
        public int calculate(String s) {
            Deque<Integer> ops = new LinkedList<Integer>();
            ops.push(1);
            int sign = 1;

            int ret = 0;
            int n = s.length();
            int i = 0;
            while (i < n) {
                if (s.charAt(i) == ' ') {
                    i++;
                } else if (s.charAt(i) == '+') {
                    sign = ops.peek();
                    i++;
                } else if (s.charAt(i) == '-') {
                    sign = -ops.peek();
                    i++;
                } else if (s.charAt(i) == '(') {
                    ops.push(sign);
                    i++;
                } else if (s.charAt(i) == ')') {
                    ops.pop();
                    i++;
                } else {
                    long num = 0;
                    while (i < n && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    ret += sign * num;
                }
            }
            return ret;
        }
    }