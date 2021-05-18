package Hot_100;

/**
 * @author:yxl
 **/
public class 买股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }


    public static int maxProfit(int[] prices) {
        int len = prices.length;
        //dp[0][i] 表示当天未持股票的资金
        //dp[1][i] 表示当天持股票的资金
        int[][] dp = new int[2][len];
        //题目规定只能交易一次
        dp[0][0] = 0;
        dp[1][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);
            //只能交易一次，即前一天不持股代表从未买过股票。
            dp[1][i] = Math.max(dp[1][i - 1], -prices[i]);
        }
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < len; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[0][len - 1];
    }
}
