package q0543;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
	}
}
public class DiameterOfBinaryTree {
	/**
	给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

	示例 :
	给定二叉树
	
	          1
	         / \
	        2   3
	       / \     
	      4   5    
	返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
	
	注意：两结点之间的路径长度是以它们之间边的数目表示。
	 */
	static int ans;
	public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
	public static int depth(TreeNode root) {
		if(root == null) return 0;
		int l = depth(root.left);
		int r = depth(root.right);
		ans = Math.max(ans, l+r+1);
		return Math.max(l, r) + 1;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		
		int res = diameterOfBinaryTree(root);
		System.out.println(res);
	}
	/*
	想法

	任意一条路径可以被写成两个 箭头（不同方向），每个箭头代表一条从某些点向下遍历到孩子节点的路径。
	
	假设我们知道对于每个节点最长箭头距离分别为 L, RL,R，那么最优路径经过 L + R + 1 个节点。
	
	算法
	
	按照常用方法计算一个节点的深度：max(depth of node.left, depth of node.right) + 1。在计算的同时，经过这个节点的路径长度为 1 + (depth of node.left) + (depth of node.right) 。搜索每个节点并记录这些路径经过的点数最大值，期望长度是结果 - 1。

	 */
}
