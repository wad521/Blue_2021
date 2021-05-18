package 基础练习;

import java.io.*;

/**
 * @author:yxl
 **/
public class 完美的代价 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        char[] s = reader.readLine().toCharArray();
        reader.close();
        if (palindrome(s, 0, len - 1)) {
            System.out.println(cnt);
        } else {
            System.out.println("Impossible");
        }
    }

    private static int cnt = 0, idx;
    private static boolean haveMiddle = false;

    private static boolean palindrome(char[] s, int a, int b) {
        if (b <= a) {
            if (haveMiddle) {
                exchangeTo(s, idx, s.length / 2);
            }
//            for (char s1 : s) {
//                System.out.print(s1);
//            }
//            System.out.println();
            return true;
        }
        // 从最后的位置开始遍历字符串
        for (int i = b; i > a; i--) {
            if (s[a] == s[i]) {
                exchangeTo(s, i, b);
                for (char s1 : s) {
                    System.out.print(s1);
                }
                System.out.println();
                cnt += getExchangeTimes(i, b);
                return palindrome(s, a + 1, b - 1);
            }
        }
        // 如果没有出现过中间字符
        if (!haveMiddle) {
            haveMiddle = true;
            idx = a;
            cnt += getExchangeTimes(a, s.length / 2);
            return palindrome(s, a + 1, b);
        }
        return false;
    }

    private static int getExchangeTimes(int a, int b) {
        return b - a;
    }

    private static void exchangeTo(char[] s, int a, int b) {
        char temp = s[a];
        for (int i = a; i < b; i++) {
            s[i] = s[i + 1];
        }
        s[b] = temp;
    }
}
