package 历届真题;

import java.util.*;

/**
 * @author:yxl
 **/
public class 子串分值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        count_1(str);
        count_2(str);
    }

    public static void count_1(String s1) {
        String s = s1;
        int one[] = new int[26];
        int two[] = new int[26];
        Arrays.fill(one, -1);
        Arrays.fill(two, -1);
        int dp[] = new int[s.length()];
        dp[0] = 1;
        one[s.charAt(0) - 'a'] = 0;
        for (int i = 1; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            if (two[a] != -1){
                dp[i] = dp[i - 1] + i - 2 * one[a] + two[a];
            }else if (one[a] != -1) {
                dp[i] = dp[i - 1] + i + 1 - 2 * (one[a] + 1);
            }
            else {
                dp[i] = dp[i - 1] + i + 1;
            }
            if (one[a] == -1) {
                one[a] = i;
            }else {
                two[a] = one[a];
                one[a] = i;
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        System.out.println(sum);
    }


    public static void count_2(String s1) {
        String str = s1;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            HashSet<String> set = new HashSet<String>();//HashSet有去重功能
            for (int j = i + 1; j <= str.length(); j++) {
                //求子串
                String s = str.substring(i, j);
                //分割子串
                String ss[] = s.split("");
                //用来记录重复字符的数据
                Set<String> list = new HashSet<>();
                for (int k = 0; k < ss.length; k++) {
                    if (set.contains(ss[k])) {
                        list.add(ss[k]);
                    } else {
                        set.add(ss[k]);
                    }
                }
                for (String q : list) {
                    set.remove(q);
                }
//                System.out.println(set);
                //将子串中的不同的字符个数累加
                sum += set.size();
                //置空
                list.clear();
                set = new HashSet<String>();
            }
        }
        System.out.println(sum);
    }

}
