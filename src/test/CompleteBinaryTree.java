package test;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String arg[]) {
		TreeNode node1 = new TreeNode(1);
	    TreeNode node2 = new TreeNode(2);
	    TreeNode node3 = new TreeNode(3);
	    TreeNode node4 = new TreeNode(4);
	    TreeNode node5 = new TreeNode(5);
	    TreeNode node6 = new TreeNode(6);
	    TreeNode node7 = new TreeNode(7);
	    
//	    node1.left = node2;
//	    node1.right = node3;
//	    node2.left = node4;
//	    node2.right = node5;
//	    node3.left = node6;
//	    node3.right = node7;
	    
//	    node1.left = node2;
//	    node1.right = node3;
//	    node2.left = node4;
//	    node2.right = node5;
//	    node3.right = node7;
	    
	    node1.left = node2;
	    node1.right = node3;
	    node2.left = node4;
	    node2.right = node5;
	    
	    System.out.println(isComplete(node1));
	}
	
	public static boolean isComplete(TreeNode node) {
		if(node == null) return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			// 删除头节点并返回该节点
			TreeNode top = queue.poll();
			// 若该节点的左子树为空，右子树非空，则非完全二叉树
			if(top.left == null && top.right != null) return false;
			// 若该节点的左右子树非空，则将左右子树入队列
			if(top.left != null && top.right != null) {
				queue.add(top.left);
				queue.add(top.right);
			}
			
			// 若该节点的左子树非空右子树为空、左右子树均为空，那么除了该节点之外的所有节点应该均为叶子节点
			if((top.left != null && top.right == null) || (top.left == null && top.right == null)) {
				if(top.left != null && top.right == null) {
					queue.add(top.left);
				}
				while(!queue.isEmpty()) {
					// 判定剩余节点是否是叶子节点
					if(top.left == null && top.right == null) {
						queue.poll();
					}else {
						return false;
					}
				}
				return true;
			}
		}
		return true;
	}

}
