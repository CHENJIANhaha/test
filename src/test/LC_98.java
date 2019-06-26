package test;

public class LC_98 {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String arg[]) {
		TreeNode node = new TreeNode(0);
//		node.left = new TreeNode(1);
//		node.right = new TreeNode(3);
		System.out.println(isValidBST(node));
	}
	
	public static boolean isValidBST(TreeNode root) {
		//Double.MAX_VALUE = 4.9E-324，当节点值为 0 的时候需要注意
		double min = -Double.MAX_VALUE;
		double max = Double.MAX_VALUE;
		
		return isValid(root, min, max);
	}
	
	public static boolean isValid(TreeNode node, double min, double max) {
		if(node == null) return true;
		System.out.println(node.val);
		System.out.println(min);
		System.out.println(max);
		System.out.println(node.val > min);
		System.out.println(node.val < max);
		if(node.val > min && node.val < max) {
			return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
		}else {
			return false;
		}
	}

}
