package 剑指Offer;

/**
 * @author:yxl
 **/
public class 单词长度的最大乘积 {
    public static void main(String[] args) {
        String[] words = new String[]{"abcw","baz","foo","bar","fxyz","abcdef"};
        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {
        int ans = 0;
        int len = words.length;
        int[] num = new int[len];

        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                int wei = word.charAt(j) - 'a';
                num[i] = (num[i] | (1 << wei));
            }
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((num[i] & num[j]) == 0) {
                    ans = Math.max(words[i].length() * words[j].length(), ans);
                }
            }
        }

        return ans;
    }
}
