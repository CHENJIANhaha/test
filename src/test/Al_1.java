package test;

/**
 * @author chenjian
 *
 */
public class Al_1 {
	public static void main(String arg[]) {
		int[] a = {4, -3, 5, -2, -1, 2, 6, -2};
		System.out.println("maxSubSum1: "+maxSubSum1(a));
		System.out.println("maxSubSum2: "+maxSubSum2(a));
		System.out.println("maxSubSum3: "+maxSubSum3(a));
		System.out.println("maxSubSum4: "+maxSubSum4(a));
		System.out.println("binarySearch: "+binarySearch(a, 2));
		System.out.println("gcd: "+gcd(1989, 1590));
		System.out.println("pow: "+pow(2, 4));
	}
	
	/**
	 * @param arg
	 * @return
	 * 最大子序列和问题
	 */
	//方法1：三重循环暴力求解，比较每一个子序列
	public static int maxSubSum1(int[] arg) {
		int maxSum = 0;
		//i 代表当前最长子序列的起点，j 代表当前序列的终点
		for(int i=0; i<arg.length; i++) {
			for(int j=i; j<arg.length; j++) {
				int tempSum = 0;
				for(int k=i; k<=j; k++) {
					tempSum += arg[k];
				}
				if(tempSum > maxSum) {
					maxSum = tempSum;
				}
			}
		}
		return maxSum;
	}
	
	//方法2：原理与方法1一样，只是没有记录每个子序列的和
	public static int maxSubSum2(int[] arg) {
		int maxSum = 0;
		for(int i=0; i<arg.length; i++) {
			int tempSum = 0;
			for(int j=i; j<arg.length; j++) {
				tempSum += arg[j];
				if(tempSum > maxSum) {
					maxSum = tempSum;
				}
			}
		}
		return maxSum;
	}
	
	//方法3：分治算法，递归求解
	public static int maxSum(int[] a, int left, int right) {
		if(left == right) {
			if(a[left] > 0) {
				return a[left];
			}else {
				return 0;
			}
		}
		
		int center = (left + right)/2;
		//左边子序列和最大
		int maxLeft = maxSum(a, left, center);
		//右边子序列和最大
		int maxRight = maxSum(a, center+1, right);
		
		//包含中间值的左边最大值
		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for(int i=center; i>=0; i--) {
			leftBorderSum += a[i];
			if(leftBorderSum > maxLeftBorderSum) {
				maxLeftBorderSum = leftBorderSum;
			}
		}
		
		//包含中间值的右边最大值
		int maxRightBorderSum = 0, rightBorderSum = 0;
		for(int i=center+1; i<=right; i++) {
			rightBorderSum += a[i];
			if(rightBorderSum > maxRightBorderSum) {
				maxRightBorderSum = rightBorderSum;
			}
		}
		
		return Math.max(Math.max(maxLeft, maxRight), maxLeftBorderSum+maxRightBorderSum);
		
	}
	public static int maxSubSum3(int[] arg) {
		return maxSum(arg, 0, arg.length-1);
	}
	
	//方法4：联机算法
	public static int maxSubSum4(int[] arg) {
		int maxSum = 0, tempSum = 0;
		for(int i=0; i<arg.length; i++) {
			tempSum += arg[i];
			if(tempSum > maxSum) {
				maxSum = tempSum;
			}else if(tempSum < 0) {//拒绝负数为起点
				tempSum = 0;
			}
		}
		return maxSum;
	}
	
	
	/**
	 * @param a
	 * @param x
	 * @return
	 * 折半查找
	 */
	public static int binarySearch(int[] a, int x) {
		int low = 0, high = a.length-1;
		
		while(low <= high) {
			int mid = (low + high)/2;
			if(x > a[mid]) {
				low = mid + 1;
			}else if(x < a[mid]) {
				high = mid - 1;
			}else {
				return mid;
			}
		}
		
		return 0;
	}
	
	/**
	 * @param m
	 * @param n
	 * @return
	 * 欧几里得算法求两数的最大公因数
	 */
	public static int gcd(int m, int n) {
		while(n != 0) {
			int temp = m % n;//余数
			m = n;
			n = temp;
		}
		return m;
	}
	
	/**
	 * @param x
	 * @param n
	 * @return
	 * 自定义求幂函数
	 */
	public static int pow(int x, int n) {
		if(n == 0) {
			return 1;
		}
		
		if(n == 1) {
			return x;
		}
		
		if(n % 2 == 0) {//n 为偶数
			return pow(x*x, n/2);
		}else {
			return pow(x, n-1);
		}
	}
	
}
