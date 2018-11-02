package test;

/**
 * 21.�ϲ����������б�
 *
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}

public class LC21_MergeTwoLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(4);
		l2.next = new ListNode(5);
		ListNode merge = merge2(l1, l2);
		
		while(l1 != null) {
			System.out.println("l1:" + l1.val);
			l1 = l1.next;
		}
		
		while(l2 != null) {
			System.out.println("l2:" + l2.val);
			l2 = l2.next;
		}
		
		while(merge != null) {
			System.out.println("merge:" + merge.val);
			merge = merge.next;
		}
		
	}
	
	//ʹ�õݹ�ϲ�
	public static ListNode merge(ListNode l1, ListNode l2) {
		ListNode result = null;
		
		if(l1 == null || l2 == null) {
			return l1 != null ? l1 : l2;
		}
		
		if(l1.val < l2.val) {
			result = l1;
			result.next = merge(l1.next, l2);
		}else {
			result = l2;
			result.next = merge(l1, l2.next);
		}
		
		return result;
	}
	
	//��ʹ�õݹ�ϲ�
	public static ListNode merge2(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) { //l1��l2����֮����һ��Ϊ��
			return l1 != null ? l1 : l2;
		}
		
		ListNode result = new ListNode(0); //�������һ���ǿյĳ�ʼֵ������result.nextΪ��ָ��
		ListNode temp = result;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				result.next = l1;
				l1 = l1.next;
			}else {
				result.next = l2;
				l2 = l2.next;
			}
			result = result.next;
		}
		
		while(l1 != null) { //��l1�ĳ��ȴ���l2
			result.next = l1;
			l1 = l1.next;
			result = result.next;
		}
		 
		while(l2 != null) { //��l2�ĳ��ȴ���l1
			result.next = l2;
			l2 = l2.next;
			result = result.next;
		}
		
		result = temp.next;
		return result;
	}
}
