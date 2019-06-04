package test;

import java.util.HashMap;

public class Offer_7 {
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
		}
	}
	public static void main(String arg[]) {
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
		TreeNode node = reContribute(pre, in);
		printTree(node);
	}
	
	static HashMap<Integer, Integer> hashmap = new HashMap<> ();
	public static TreeNode reContribute(int[] pre, int[] in) {
		if(pre == null || in == null) return null;
		for(int i=0; i<in.length; i++) {
			hashmap.put(in[i], i);
		}
		return reContributeTree(pre, 0, pre.length-1, 0);
	}
	
	public static TreeNode reContributeTree(int[] pre, int preL, int preR, int inL) {
		if(preL > preR) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preL]);
		int rootIndexIn = hashmap.get(root.val);
		int leftTreeSize = rootIndexIn - inL;
		root.left = reContributeTree(pre, preL+1, preL+leftTreeSize, inL);
		root.right = reContributeTree(pre, preL+leftTreeSize+1, preR, inL+leftTreeSize+1);
		return root;
	}
	
	public static void printTree(TreeNode node) {
		if(node != null) {
			System.out.println(node.val + " ");
			printTree(node.left);
			printTree(node.right);
		}
	}
}
