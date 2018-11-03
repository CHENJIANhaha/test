package test;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 22.括号生成
 *
 */
public class LC22_GenerateParentheses {
	static List<String> total = new ArrayList<> ();
	public static void main(String[] args) {
		List<String> list = generateParentheses(2); 
		String[] result = new String[list.size()];
		
		for(int i=0; i<list.size(); i++) {
			result[i] = list.get(i);
		}
		System.out.println(Arrays.toString(result));
	}
	
	public static List<String> generateParentheses(int n) {
		String str = "";
		for(int i=0; i<n; i++) {
			str += "()";
		}
		String[] brackets = str.split("");
		permutation(2*n, brackets);
		List<String> generateP = total;
		for(int i=0; i<total.size(); i++) {
			String test = total.get(i);
			if(!isValid(test)) {
				generateP.remove(test);
			}
		}
		System.out.println(total);
		return generateP;
	}
	
	public static void permutation(int n, String[] arr) {
		if(n == 1) {
			String str = "";
			for(int i=0; i<arr.length; i++) {
				str += arr[i];
			}
			if(!total.contains(str)) {
				total.add(str);
			}
		}else {
			for(int i=0; i<n-1; i++) {
				permutation(n-1, arr);
				if(n%2 == 0) {
					swap(arr, i, n-1);
				}else {
					swap(arr, 0, n-1);
				}
			}
			permutation(n-1, arr);
		}
	}
	
	public static void swap(String[] arr, int a, int b) {
		String temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
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
