package test;

public class List {
	public class Node {
		//Ϊ�˷��㣬������������ʹ��public��������private�Ͳ���Ҫ��дget��set�����ˡ�
	    //������ݵı������򵥵㣬ֱ��Ϊint��
	    public int data;
	    //��Ž��ı���,Ĭ��Ϊnull
	    public Node next;
	    //���췽�����ڹ���ʱ���ܹ���data��ֵ
	    public Node(int data){
	        this.data = data;
	    }
	}
	
	//��ʼ��ͷ���
	private Node head;
	private Node temp;
	private int length;
	
	//��������ĳ���
	public int length() {
		return length;
	}
	
	//������β����ӽ��
	public void add(int number) {
		Node node = new Node(number);
		if(head == null) {
			head = node;
			temp = node;
		}else {
			temp.next = node;
			temp = temp.next;
		}
		length++;
	}
	
	//������ͷ����ӽ��
	public void addHead(int number) {
		Node node = new Node(number);
		if(head == null) {
			head = node;
			temp = node;
		}else {
			node.next = head.next;
			head.next = node;
		}
	}
	
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return head == null ? true : false;
	}
	
	//�ж������Ƿ����ĳ��Ԫ��
	public boolean contain(int data) {
		return isContain(head, data);
	}
	
	public int getData(int index) {
		if(index < 0 || index >= length) {
			return -1;
		}
		return getDataByIndex(head, 0, index);
	}
	
	public void printAll() {	
		print(head);
	}
	
	private boolean isContain(Node node, int data) {
		if(node == null) {
			return false;
		}
		if(data == node.data) {
			return true;
		}
		return isContain(node.next, data);
	}
	
	private int getDataByIndex(Node node, int point, int index) {
		if(point == index) {
			return node.data;
		}
		return getDataByIndex(node.next, ++point, index);
	}
	
	private void print(Node node) {
		if(node == null) {
			return;
		}
		System.out.println(node.data);
		print(node.next);
	}
	
	public static List addTwoNumbers(List n1, List n2) {
		List result = new List();
		int carry = 0;
		int sum = 0;
		int l1 = n1.length();
		int l2 = n2.length();
		if(l1 == l2) {
			for(int i = 0; i < l1; i++) {
				sum = n1.getData(i) + n2.getData(i) + carry;
				carry = sum/10;
				result.add(sum%10);
			}
		}else if(l1 < l2) {
			for(int i = 0; i < l2; i++) {
				if(i < l1) {
					sum = n1.getData(i) + n2.getData(i) + carry;
					carry = sum/10;
					result.add(sum%10);
				}else {
					sum = carry + n2.getData(i);
					carry = sum/10;
					result.add(sum%10);
				}
			}
			
		}else {
			for(int i = 0; i < l1; i++) {
				if(i < l2) {
					sum = n1.getData(i) + n2.getData(i) + carry;
					carry = sum/10;
					result.add(sum%10);
				}else {
					sum = carry + n1.getData(i);
					carry = sum/10;
					result.add(sum%10);
				}
			}
		}
		if(carry != 0) {
			result.add(1);
		}
		result.printAll();
		return result;
		
	}
	
	public static void main(String[] args) {
		List list1 = new List();
		List list2 = new List();
		list1.add(5);
		list1.add(6);
		list1.add(7);
		list2.add(1);
		list2.add(2);
		list2.add(3);
		addTwoNumbers(list1, list2);
	}

}
