package test;

import java.util.Stack;

/**
 * 20.��Ч������
 *
 */
public class LC20_ValidParentheses {
	public static void main(String[] args) {
		System.out.println(isValid("]"));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] arr = s.toCharArray();
		
		if(s.length()%2 != 0) { //�ַ�����Ϊ����ʱֱ�ӷ���false
			return false;
		}
		
		for(int i=0; i<arr.length; i++) {
			//����������ƥ��ķ�����ѹ��ջ
			if(arr[i] == '(') {
				stack.push(')');
			}else if(arr[i] == '[') {
				stack.push(']');
			}else if(arr[i] == '{') {
				stack.push('}');
			}
			
			//ջ��Ԫ������һ������ƥ�䣬��ջ��Ԫ�ص����������ջΪ������Ч
			if(!stack.empty() && (i+1) != arr.length && stack.peek().equals(arr[i+1])) {
				stack.pop();
			}
		}
		return stack.empty();
	}
}
