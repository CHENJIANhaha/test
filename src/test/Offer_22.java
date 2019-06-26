package test;

public class Offer_22 {
	private static class Node {
		int val;
		Node next;
		Node(int x) {
			this.val = x;
		}
	}
	public static void main(String[] arg) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		System.out.println(findKthToTail(node, 1).val);
	}
	
	public static Node findKthToTail(Node head, int k) {
		if(head == null || k == 0) return null;
		Node quick = head;
		Node slow = head;
		// 将快指针先移动 k-1 位
		while(--k > 0) {
			if(quick.next != null) {
				quick = quick.next;
			}else {
				return null;
			}
		}
		while(quick.next != null) {
			quick = quick.next;
			slow = slow.next;
		}
		return slow;
		
	}

}
