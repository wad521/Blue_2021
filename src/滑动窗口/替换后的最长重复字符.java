package 滑动窗口;

public class 替换后的最长重复字符 {

    public static void main(String[] args) {
        String s = "CAABBCCC";
        System.out.println(characterReplacement(s,2));
    }
    public static int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            //nums中的值只代表窗口中包含的字符的数量，一旦窗口移动，则left代表的数量--；
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
            for (int i = 0; i <26 ; i++) {
                System.out.print(num[i]+" ");
            }
            System.out.println();
        }
        return right - left;
    }
}
