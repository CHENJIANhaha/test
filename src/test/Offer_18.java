package test;

public class Offer_18 {
	private static class Node {
		int val;
		Node next;
		Node(int x) {
			this.val = x;
		}
	}
	
	public static void main(String arg[]) {
		Node n1 = new Node(2);
		n1.next = new Node(2);
		n1.next.next = new Node(2);
		n1.next.next.next = new Node(3);
		n1 = deleteDuplication2(n1);
		while(n1 != null) {
			System.out.println(n1.val);
			n1 = n1.next;
		}
	}
	
	public static Node deleteNode(Node head, Node node) {
		if(head == null || node == null) return null;
		// 若果待删节点的 next ！= null，那么将 next 的值赋给 node，并删除 next
		if(node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}else {
			// node 为头节点
			if(head == node) {
				head = null;
			}else {
				// node 为尾节点，则需要找到 node 的前驱，删除 node
				Node cur = head;
				while(cur.next != node) {
					cur = cur.next;
				}
				cur.next = null;
			}
		}
		return head;
	}
	
	public static Node deleteDuplication(Node pHead) {
		if(pHead == null || pHead.next == null) return pHead;
		Node cur = pHead;
		Node pre = null;
		while(cur != null) {
			boolean isDelete = false;
			if(cur.next != null && cur.val == cur.next.val) {
				isDelete = true;
			}
			// 当前节点没有重复项
			if(!isDelete) {
				pre = cur;
				cur = cur.next;
			}else {
				int dup = cur.val;
				Node delete = cur.next.next;
				// 找出所有重复项
				while(delete != null && delete.val == dup) {
					delete = delete.next;
				}
				// 头节点重复
				if(pre == null) {
					pHead = delete;
				}else {
					pre.next = delete;
				}
				cur = delete;
			}
		}
		return pHead;
	}
	
	public static Node deleteDuplication2(Node pHead) {
		if(pHead == null || pHead.next == null) return pHead;
		Node next = pHead.next;
		// 当头节点为重复节点时，对非重复节点进行递归
		if(pHead.val == next.val) {
			while(next != null && pHead.val == next.val) {
				next = next.next;
			}
			return deleteDuplication2(next);
		}else {
			// 当头节点不为重复节点时，对头节点的后驱进行递归，并将头节点指向返回的结果
			pHead.next = deleteDuplication2(next);
			return pHead;
		}
	}

}
