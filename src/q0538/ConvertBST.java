package q0538;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
	}
}
public class ConvertBST {
	/**
	给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

	例如：
	
	输入: 二叉搜索树:
	              5
	            /   \
	           2     13
	
	输出: 转换为累加树:
	             18
	            /   \
	          20     13
	 */
	private int sum = 0;
	public TreeNode convertBST(TreeNode root) {
		if(root == null) return root;
        if(root != null){
        	convertBST(root.right);
        	sum += root.val;
        	root.val = sum;
        	convertBST(root.left);
        }
        return root;
    }
	
	public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;
            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }
        return root;
    }
}
