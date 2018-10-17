package test;

public class Reverse {
	public static void main(String[] args) {
		System.out.println(reverse(123));
	}
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
