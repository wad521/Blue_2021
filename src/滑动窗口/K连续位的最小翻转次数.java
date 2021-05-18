package 滑动窗口;

/**
 * @author:yxl
 **/
public class K连续位的最小翻转次数 {
    public static void main(String[] args) {
        int[] A = new int[]{0,1,1,0,0,0,0,1,0,1,1,0};
        System.out.println(minKBitFlips(A,3));
    }
    public  static int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            System.out.println("revCnt: "+revCnt);
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        for(int i:diff){
            System.out.print(i+" ");
        }
        System.out.println();
        return ans;
    }
}
