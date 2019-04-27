package test;

/**
 * 7.反转整数
 */
public class LC7_Reverse {
	
	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}
	
	//使用字符串反转数字
	public static int reverse(int x) {

		int y = 0;
		char[] array;
		if(x > 0) {
			array = Integer.toString(x).toCharArray();
		}else {
			array = Integer.toString(-x).toCharArray();
		}
		
		String result = "";
		for(int i=array.length-1; i>=0; i--) {
			result += array[i];
		}

		//字符转数字时捕获异常，针对溢出检查
		try {
			Integer.parseInt(result);
		}catch(NumberFormatException e) {
			return y;
		}
		
		if(x > 0) {
			y = Integer.parseInt(result);
		}else {
			y = -Integer.parseInt(result);
		}
		
		return y;
	}
}
