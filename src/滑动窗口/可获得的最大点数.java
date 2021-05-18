package 滑动窗口;

public class 可获得的最大点数 {
    public static void main(String[] args) {
        int [] cardPoints = new int[]{1,1000,1};
        System.out.println(maxScore(cardPoints,1));
    }
        public static int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += cardPoints[i];
            }
            int maxSum = sum;
            for (int i = 1; i <= k; i++) {
                sum += cardPoints[n-i] - cardPoints[k-i];
                maxSum = Math.max(maxSum, sum);
            }
            return maxSum;
        }
}
