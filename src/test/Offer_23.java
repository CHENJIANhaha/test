package test;

public class Offer_23 {
	private static class Node {
		int val;
		Node next;
		Node(int x) {
			this.val = x;
		}
	}
	public static void main(String arg[]) {
		
	}
	
	public static Node EntryNodeOfLoop(Node head) {
		if(head == null || head.next == null) return null;
		Node quick = head;
		Node slow = head;
		do {
			quick = quick.next.next;
			slow = slow.next;
		}while(quick != slow);
		quick = head;
		while(quick != slow) {
			quick = quick.next;
			slow = slow.next;
		}
		return slow;
	}

}
