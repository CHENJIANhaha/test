package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * 22.��������
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
		
		System.out.println("����1��"+Arrays.toString(result1));
		System.out.println("����2��"+Arrays.toString(result2));
	}
	
		
	//����һ���������е���Ч���ţ��÷����ύ�󳬳�ʱ������
	public static List<String> generateParentheses(int n) {
		String str = "";
		for(int i=0; i<n; i++) { 
			str += "()";
		}
		String[] brackets = str.split(""); //���е�ԭʼ��������
		permutation(2*n, brackets); //�����е����Ž���ȫ����
		Iterator<String> it = total.iterator();
		while(it.hasNext()) { //ȥ��total����Ч������
			String x = it.next();
			if(!isValid(x.toCharArray())) {
				it.remove();
			}
		}
		/*List<String> generateP = new ArrayList<> (); //�����Ч������
		for(int i=0; i<total.size(); i++) {
			String test = total.get(i);
			if(isValid(test)) {
				generateP.add(test);
			}
		}*/
		return total;
	}
	
	//��������������
	public static List<String> generateValid(int n) {
		char[] arr = new char[2*n];
		int pos = 0;
		List<String> result = new ArrayList<> ();
		generateAll(arr, pos, result);
		return result;
	}
	
	//�����������ݷ�
	
	//�����ģ��պ���
	
	//�������п��ܵ��������
	public static void generateAll(char[] arr, int pos, List<String> list) {
		if(pos == arr.length) { 
			if(isValid(arr)) { //�жϵ�ǰ��������Ƿ���Ч
				list.add(new String(arr));
			}
		}else {
			arr[pos] = '(';
			generateAll(arr, pos+1, list);
			arr[pos] = ')';
			generateAll(arr, pos+1, list);
		}
	}
	
	//���ŵ�ȫ����
	public static void permutation(int n, String[] arr) {
		if(n == 1) {
			String str = "";
			for(int i=0; i<arr.length; i++) {
				str += arr[i];
			}
			if(!total.contains(str)) { //totalȥ��
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
	
	//��������������ָ��Ԫ�ص�λ�ã�����ȫ���к���
	public static void swap(String[] arr, int a, int b) {
		String temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	//�ж��Ƿ�Ϊ��Ч���������
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
