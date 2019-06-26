package test;

public class Offer_16 {
	public static void main(String arg[]) {
		System.out.println(Power(0, -3));
	}
	
	public static double Power(double base, int exponent) {
		// 记录指数是否为负数，如果为负数则需要进行倒数处理
		boolean isNegative = false;
		// base 为 0 的情况， 通常 0 的 0 次方没有意义，但是此处定义 0 的 0 次方为 1
		if(base == 0 && exponent != 0) return 0;
		if(base == 0 && exponent == 0) return 1;
		if(exponent == 0) return 1;
		if(exponent == 1) return base;
		if(exponent < 0) {
			isNegative = true;
			exponent = -exponent;
		}
		double result = Power(base * base, exponent / 2);
		if(exponent % 2 != 0) {
			result *= base;
		}
		
		return isNegative ? 1 / result : result;
	}

}
