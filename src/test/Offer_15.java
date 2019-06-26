package test;

public class Offer_15 {
	public static void main(String arg[]) {
		System.out.println(countOne2(-5));
		
	}
	
	public static int countOne(int n) {
		int count = 0;
		while(n != 0) {
			n = n&(n-1);
			count++;
		}
		return count;
	}
	
	public static int countOne2(int n) {
		return Integer.bitCount(n);
	}

}
