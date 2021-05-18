package 滑动窗口;

/**
 * @author:yxl
 **/
public class 最大连续1的个数III {
    public static void main(String[] args) {
        int[] num = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(num,2));
    }

    public static int longestOnes(int[] A, int K) {
        int n = A.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - A[right];
            while (lsum < rsum - K) {
                lsum += 1 - A[left];
                ++left;
            }
            System.out.println("lsum: "+left+"   rsum:"+rsum);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
