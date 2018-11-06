package test;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 22.括号生成
 *
 */
public class LC22_GenerateParentheses {
	static List<String> total = new ArrayList<> ();
	public static void main(String[] args) {
		List<String> list = generateParentheses(3); 
		String[] result = new String[list.size()];
		
		for(int i=0; i<list.size(); i++) {
			result[i] = list.get(i);
		}
		System.out.println(Arrays.toString(result));
	}
	
	//生成所有的有效括号
	public static List<String> generateParentheses(int n) {
		String str = "";
		for(int i=0; i<n; i++) { 
			str += "()";
		}
		String[] brackets = str.split(""); //所有的原始括号数组
		permutation(2*n, brackets); //将所有的括号进行全排列
		Iterator<String> it = total.iterator();
		while(it.hasNext()) { //去掉total中无效的括号
			String x = it.next();
			if(!isValid(x)) {
				it.remove();
			}
		}
		/*List<String> generateP = new ArrayList<> (); //存放有效的括号
		for(int i=0; i<total.size(); i++) {
			String test = total.get(i);
			if(isValid(test)) {
				generateP.add(test);
			}
		}*/
		return total;
	}
	
	//括号的全排列
	public static void permutation(int n, String[] arr) {
		if(n == 1) {
			String str = "";
			for(int i=0; i<arr.length; i++) {
				str += arr[i];
			}
			if(!total.contains(str)) { //total去重
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
	
	//交换数组中两个指定元素的位置，用于全排列函数
	public static void swap(String[] arr, int a, int b) {
		String temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	//判断是否为有效的括号组合
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
