package LeetCode_3月;

import java.util.*;

/**
 * @author:yxl
 **/
public class 逆波兰表达式求值 {
    public static void main(String[] args) {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }


    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            String s = tokens[i];
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                System.out.println(num1 + " " + num2);
                switch (s) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public static boolean isNumber(String s) {
        return !("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }
}
