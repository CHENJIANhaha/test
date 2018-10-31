package test;

public class List {
	public class Node {
		//为了方便，这两个变量都使用public，而不用private就不需要编写get、set方法了。
	    //存放数据的变量，简单点，直接为int型
	    public int data;
	    //存放结点的变量,默认为null
	    public Node next;
	    //构造方法，在构造时就能够给data赋值
	    public Node(int data){
	        this.data = data;
	    }
	}
	
	//初始化头结点
	private Node head;
	private Node temp;
	private int length;
	
	//计算链表的长度
	public int length() {
		return length;
	}
	
	//在链表尾部添加结点
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
	
	//在链表头部添加结点
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
	
	//判断链表是否为空
	public boolean isEmpty() {
		return head == null ? true : false;
	}
	
	//判断链表是否包含某个元素
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
