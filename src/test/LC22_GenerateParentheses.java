package test;

import java.util.List;
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
		List<String> list1 = generateParentheses(3); 
		List<String> list2 = generateValid(3);
		String[] result1 = new String[list1.size()];
		String[] result2 = new String[list2.size()];

		for(int i=0; i<list1.size(); i++) {
			result1[i] = list1.get(i);
		}
		
		for(int i=0; i<list2.size(); i++) {
			result2[i] = list2.get(i);
		}
		
		System.out.println("方法1："+Arrays.toString(result1));
		System.out.println("方法2："+Arrays.toString(result2));
	}
	
		
	//方法一：生成所有的有效括号，该方法提交后超出时间限制
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
			if(!isValid(x.toCharArray())) {
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
	
	//方法二：暴力法
	public static List<String> generateValid(int n) {
		char[] arr = new char[2*n];
		int pos = 0;
		List<String> result = new ArrayList<> ();
		generateAll(arr, pos, result);
		return result;
	}
	
	//方法三：回溯法
	
	//方法四：闭合数
	
	//生成所有可能的括号组合
	public static void generateAll(char[] arr, int pos, List<String> list) {
		if(pos == arr.length) { 
			if(isValid(arr)) { //判断当前括号组合是否有效
				list.add(new String(arr));
			}
		}else {
			arr[pos] = '(';
			generateAll(arr, pos+1, list);
			arr[pos] = ')';
			generateAll(arr, pos+1, list);
		}
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
	public static boolean isValid(char[] arr) {
		int balance = 0;
		for(char c: arr) {
			if(c == '(') {
				balance++;
			}else {
				balance--;
			}
			if(balance < 0) {
				return false;
			}
		}
		return (balance == 0);
	}
}
