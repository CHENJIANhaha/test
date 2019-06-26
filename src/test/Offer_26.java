package test;

public class Offer_26 {
	private static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String arg[]) {
		
	}
	
	public static boolean hasSubTree(TreeNode node1, TreeNode node2) {
		if(node1 == null || node2 == null) return false;
		// 判断树1是否存在与树2相同的根节点
		return isSubTree(node1, node2) || hasSubTree(node1.left, node2) || hasSubTree(node1.right, node2);
	}
	
	// 判断两棵树是否相同
	public static boolean isSubTree(TreeNode node1, TreeNode node2) {
		if(node1 == null) return false;
		if(node2 == null) return true;
		if(node1.val != node2.val) return false;
		return isSubTree(node1.left, node2.left) && isSubTree(node1.right, node2.right);
 	}

}
