package 滑动窗口;

public class 尽可能使字符串相等 {
    public static void main(String[] args) {
        String s = "aaaaaa";
        String t = "acccbc";
        System.out.println(equalSubstring(s,t,5));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] accDiff = new int[n + 1];
        System.out.print(accDiff[0]+" ");
        for (int i = 0; i < n; i++) {
            accDiff[i + 1] = accDiff[i] + Math.abs(s.charAt(i) - t.charAt(i));
            System.out.print(accDiff[i+1]+" ");
        }
        System.out.println();
        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            int start = binarySearch(accDiff, i, accDiff[i] - maxCost);
            maxLength = Math.max(maxLength, i - start);
            System.out.println(maxLength);
        }
        return maxLength;
    }

    public static int binarySearch(int[] accDiff, int endIndex, int target) {
        //low 表示第一个大于等于 target的值的下标
        int low = 0, high = endIndex;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (accDiff[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println("low: "+low+"    target: "+target);
        return low;
    }
}