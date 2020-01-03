package q0226_binaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
	}
}
public class InvertBinaryTree {
	/**
	翻转一棵二叉树。
	输入：
	
	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	
	输出：
	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
	 */
	//DFS深度优先
	public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
	
	//BFS广度优先
	public TreeNode invertTree2(TreeNode root) {
		if(root == null) return root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			TreeNode tmp = cur.left;
			cur.left = cur.right;
			cur.right = tmp;
			if(cur.left != null) queue.add(cur.left);
			if(cur.right != null) queue.add(cur.right);
		}
		return root;
    }
}
