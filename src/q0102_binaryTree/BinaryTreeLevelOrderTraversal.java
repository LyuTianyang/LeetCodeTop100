package q0102_binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
	}
}
public class BinaryTreeLevelOrderTraversal {

	/**
		给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
		例如:
		给定二叉树: [3,9,20,null,null,15,7],
		
		    3
		   / \
		  9  20
		    /  \
		   15   7
		返回其层次遍历结果：
		[
		  [3],
		  [9,20],
		  [15,7]
		]
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);//把根节点放入队列之中
		while(!queue.isEmpty()){
			//当前层级有几个节点
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<size; i++){
				TreeNode cur = queue.poll();
				if(cur.left != null) queue.offer(cur.left);
				if(cur.right != null) queue.offer(cur.right);
				list.add(cur.val);
			}
			res.add(list);
		}
		return res;
    }
}
