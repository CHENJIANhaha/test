package test;

public class Offer_14 {
	public static void main(String[] arg) {
		System.out.println(integerBreak(10));
		System.out.println(integerBreak(10));
	}
	
	public static int integerBreak(int length) {
		if(length < 2) return 0;
		if(length == 2) return 1;
		if(length == 3) return 2;
		
		int timesOf3 = length / 3;
		// 尽可能地多剪长度为3的绳子，当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子
		if(length - timesOf3 * 3 == 1) {
			timesOf3--;
		}
		
		int timesOf2 = (length - timesOf3 * 3) / 2;
		return (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
	}
	
	public static int integerBreak2(int length) {
		// 存放每个子问题的最优解
		int[] dp = new int[length+1];
		dp[1] = 1;
		for(int i = 2; i <= length; i++) {
			// 从长度为1的线段开始计算
			for(int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
			}
		}
		return dp[length];
	}

}
