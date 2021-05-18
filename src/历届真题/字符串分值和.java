package 历届真题;

/**
 * @author:yxl
 **/
//对于一个字符串 S，我们定义 S 的分值 f(S ) 为 S 中出现的不同的字符个 数。例如 f(”aba”) = 2，f(”abc”) = 3,
//        f(”aaa”) = 1。 现在给定一个字符串 S [0…n − 1]（长度为 n），请你计算对于所有 S 的非空 子串 S [i… j](0 ≤ i ≤ j < n)，
//        f(S [i… j]) 的和是多少

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 字符串分值和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String a[] = new String[40000000];
        int k = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                a[k] = (s.substring(i, j));
                k++;
            }
        }
        for (int i = 0; i < k; i++) {
            Set<String> set = new HashSet<String>();
            for (int j = 0; j < a[i].length(); j++) {
                set.add(a[i].charAt(j) + "");
            }
            count = count + set.size();
        }
        System.out.print(count);
    }
}