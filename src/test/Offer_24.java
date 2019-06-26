package test;

public class Offer_24 {
	private static class Node {
		int val;
		Node next;
		Node(int x) {
			this.val = x;
		}
	}
	
	public static void main(String arg[]) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		Node result = reverse(node);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static Node reverse(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node pre = null;
		Node cur = head;
		while(cur != null) {
			Node temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
}
