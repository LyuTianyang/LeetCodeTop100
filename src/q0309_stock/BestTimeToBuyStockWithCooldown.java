package q0309_stock;

public class BestTimeToBuyStockWithCooldown {
	/**
	给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

	设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
	
	你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
	卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
	示例:
	
	输入: [1,2,3,0,2]
	输出: 3 
	解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
	 */
	public static int maxProfit1(int[] prices) {
        if(prices == null || prices.length <= 1) return  0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        //init
        dp[0][0] = 0;
        dp[1][0] = Math.max(0, prices[1]-prices[0]);
        dp[0][1] = -prices[0];
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        //function
        for(int i=2; i<n; i++){
        	dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
        	dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }
	
	public static int maxProfit2(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
	
	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		int res = maxProfit1(prices);
		System.out.println(res);
	}
}
