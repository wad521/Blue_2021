package 滑动窗口;

public class 最长湍流子数组 {
    public static void main(String[] args) {
        int[] num  = new int[]{9,4,2,8,7,8,8,1,9};
        for (int s :num){
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println(maxTurbulenceSize_动态规划(num));
    }
    public static int maxTurbulenceSize_动态规划(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }

        int N = A.length;
        int[] f = new int[N+1];
        int[] g = new int[N+1];
        f[1] = 1;
        g[1] = 1;

        int res = 1;
        for (int k = 2; k <= N; k++) {
            if (A[k-1] > A[k-2]) {
                f[k] = g[k-1] + 1;
            } else {
                f[k] = 1;
            }
            if (A[k-1] < A[k-2]) {
                g[k] = f[k-1] + 1;
            } else {
                g[k] = 1;
            }
            res = Math.max(res, f[k]);
            res = Math.max(res, g[k]);
        }
        for (int i : f) {
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i :g){
            System.out.print(i+" ");
        }
        System.out.println();
        return res;
    }

    public static int maxTurbulenceSize_窗口(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return len;
        }

        int left = 0;
        int right = 1;
        // 为 true 表示 arr[i - 1] < arr[i]
        //true表示[right-1]->[right]上升
        //false表示下降
        boolean pre = false;
        int res = 1;
        while (right < len) {
            boolean current = arr[right - 1] < arr[right];
            if (right == 1 || current == pre) {
                left = right - 1;
            }
            if (arr[right - 1] == arr[right]) {
                left = right;
            }
            right++;
            res = Math.max(res, right - left);
            pre = current;
        }
        return res;
    }
}
