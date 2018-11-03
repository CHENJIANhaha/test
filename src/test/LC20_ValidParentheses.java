package test;

import java.util.Stack;

/**
 * 20.有效的括号
 *
 */
public class LC20_ValidParentheses {
	public static void main(String[] args) {
		System.out.println(isValid("]"));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] arr = s.toCharArray();
		
		if(s.length()%2 != 0) { //字符长度为奇数时直接返回false
			return false;
		}
		
		for(int i=0; i<arr.length; i++) {
			//将与正括号匹配的反括号压入栈
			if(arr[i] == '(') {
				stack.push(')');
			}else if(arr[i] == '[') {
				stack.push(']');
			}else if(arr[i] == '{') {
				stack.push('}');
			}
			
			//栈顶元素与下一个括号匹配，则将栈顶元素弹出，最后若栈为空则有效
			if(!stack.empty() && (i+1) != arr.length && stack.peek().equals(arr[i+1])) {
				stack.pop();
			}
		}
		return stack.empty();
	}
}
