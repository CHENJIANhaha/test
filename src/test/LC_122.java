package test;

import java.io.IOException;

public class LC_122 {
	public static void main(String args[]) throws IOException {
		int[] test = {7,6,4,3,1};
		System.out.println(maxProfit(test));
	}
	
	//使用递归暴力求解
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
}
