package test;

import java.util.ArrayList;
import java.util.Stack;

public class Offer_6 {
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String arg[]) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		System.out.println(printListReversingly(null));
		System.out.println(printListReversingly2(l1));
	}
	
	public static ArrayList<Integer> printListReversingly(ListNode node) {
		Stack<Integer> stack = new Stack<> ();
		while(node != null) {
			stack.push(node.val);
			node = node.next;
		}
		
		ArrayList<Integer> list = new ArrayList<> ();
		while(!stack.empty()) {
			list.add(stack.pop());
		}
		
		return list;
	}
	
	public static ArrayList<Integer> printListReversingly2(ListNode node) {
		ArrayList<Integer> list = new ArrayList<> ();
		if(node != null) {
			list.addAll(printListReversingly2(node.next));
			list.add(node.val);
		}
		return list;
	}
}
