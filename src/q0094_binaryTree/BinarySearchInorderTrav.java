package q0094_binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
	}
}

public class BinarySearchInorderTrav {
	/**
	前序遍历：根结点 ---> 左子树 ---> 右子树

	中序遍历：左子树---> 根结点 ---> 右子树

	后序遍历：左子树 ---> 右子树 ---> 根结点
	
	 给定一个二叉树，返回它的中序 遍历。
	示例:
	   1
	    \
	     2
	    /
	   3
	输入: [1,null,2,3]
	输出: [1,3,2]
	   1
	    \
	     2
	    / \
	   3   4
	1,3,2,4
	 */
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		helper(res, root);
		return res;
    }
	
	public static void helper(List<Integer> res, TreeNode root) {
		if(root == null) return;
		if(root.left != null){
			helper(res, root.left);
		}
		res.add(root.val);
		if(root.right != null){
			helper(res, root.right);
		}
	}

	public static List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		List<Integer> res = inorderTraversal(root);
		System.out.println(res);
	}
}
