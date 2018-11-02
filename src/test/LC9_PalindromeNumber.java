package test;

/**
 * 9.������
 *
 */
public class LC9_PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(palindrome2(121));
	}
	
	//����һ������ת�ַ���
	public static Boolean palindrome(int number) {
		String origin = Integer.toString(number);
		char[] str = origin.toCharArray();
		String reverse = "";
		for(int i=str.length-1; i>=0; i--) {
			reverse += str[i];
		}
		return origin.equals(reverse);
	}
	
	//����������תһ������
	public static Boolean palindrome2(int number) {
		//����С��0����10�ı���һ�����ǻ�����
		if(number < 0 || (number != 0 && number%10 == 0)) {
			return false;
		}
		
		//��ԭʼ���ֶ԰�ֿ�������ǰһ�룬��һ����з�ת����ת�������Ӧ�õ���ԭʼ����
		int reverseNumber = 0;
		while(number > reverseNumber) { //��ԭʼ����С�ڷ�ת����ʱ��֤����ת���ֵ�λ���Ѿ��ﵽԭʼ���ֵ�һ��
			reverseNumber = reverseNumber*10 + number%10; //��ת����
			number = number/10; //ԭʼ����
		}
		
		return number == reverseNumber || number == reverseNumber/10; //ԭʼ���ֵ�λ��Ϊż��||ԭʼ���ֵ�λ��Ϊ����
	}
}
