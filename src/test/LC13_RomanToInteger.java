package test;

/**
 * 13.��������ת����
 *
 */
public class LC13_RomanToInteger {
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
	
	public static int romanToInt(String s) {
		char[] arr = s.toCharArray();
		int number = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(i<arr.length-1 && charToInt(arr[i]) < charToInt(arr[i+1])) {
				number -= 2*charToInt(arr[i]); //���iС��i+1˵���ⲿ����������ת������Ҫi+1��ȥi�������ڼ���i-1ʱ�Ѿ���i�ӹ�һ�Σ�����������Ҫ��i������
			}
			number += charToInt(arr[i]);
		}
		
        return number;
    }
	
	public static int charToInt(char c) {
		int number = 0;
		switch(c) {
		case 'I':
			number = 1;
			break;
		case 'V':
			number = 5;
			break;
		case 'X':
			number = 10;
			break;
		case 'L':
			number = 50;
			break;
		case 'C':
			number = 100;
			break;
		case 'D':
			number = 500;
			break;
		case 'M':
			number = 1000;
			break;
		}
		return number;
	}
}
