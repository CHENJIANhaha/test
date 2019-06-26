package test;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class LC_101 {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String arg[]) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(2);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(4);
		node.right.left = new TreeNode(4);
		node.right.right = new TreeNode(3);
		
		TreeNode node2 = new TreeNode(1);
		node2.left = new TreeNode(2);
		node2.right = new TreeNode(2);
		node2.left.right = new TreeNode(3);
		node2.right.right = new TreeNode(3);
		
		TreeNode node3 = new TreeNode(1);
		node3.left = new TreeNode(2);
		node3.right = new TreeNode(2);
		node3.left.left = new TreeNode(2);
		node3.right.left = new TreeNode(2);
		System.out.println(isSymmetric(node3));
	}
	
	public static boolean isSymmetric(TreeNode node) {
		return isMirror(node, node);
	}
	
	public static boolean isMirror(TreeNode node1, TreeNode node2) {
		// 左右节点均为 null
		if(node1 == null && node2 == null) {
			return true;
		}
		
		// 左右节点中的一个为 null
		if(node1 == null || node2 == null) {
			return false;
		}
		
		return (node1.val == node2.val) && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
	}
	
	//中序遍历树，此方法对于 node3 这种情况无效
	public static boolean isSymmetric2(TreeNode node) {
		if(node == null) return true;
		inOrder(node);
		System.out.println(list);
		for(int i=0; i<list.size()/2; i++) {
			if(list.get(i) != list.get(list.size() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void inOrder(TreeNode node) {
		if(node.left != null) {
			inOrder(node.left);
		}
		
		list.add(node.val);
		
		if(node.right != null) {
			inOrder(node.right);
		}
	}
}
