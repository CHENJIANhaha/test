package test;

import java.io.IOException;

// 122. 买卖股票的最佳时机Ⅱ
public class LC_122 {
	public static void main(String args[]) throws IOException {
		int[] test = {7,6,4,3,1};
		System.out.println(maxProfit2(test));
	}
	
	//方法一：使用递归暴力求解
	public static int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public static int calculate(int prices[], int s) {
    	if(s >= prices.length) return 0;
    	int max = 0;
    	for(int i=s; i<prices.length; i++) {
    		int maxprofit = 0;
    		for(int j=i+1; j<prices.length; j++) {
        		if(prices[i] < prices[j]) {
        			int profit = calculate(prices, j+1) + prices[j] - prices[i];
        			if(profit > maxprofit) maxprofit = profit;
        		}
        	}
    		if(maxprofit > max) max = maxprofit;
    	}
    	return max;
    }
    
    //方法二：峰谷法
    public static int maxProfit2(int[] prices) {
    	if(prices.length <= 0) return 0;
    	int maxProfit = 0;
    	int valley = prices[0];
    	int peak = prices[0];
    	int i = 0;
    	while(i < prices.length -1) {
    		while(i < prices.length-1 && prices[i+1] <= prices[i]) i++;
    		valley = prices[i];
    		while(i < prices.length-1 && prices[i+1] >= prices[i]) i++;
    		peak = prices[i];
    		maxProfit += peak - valley;
    	}
    	return maxProfit;
    }
    
}
