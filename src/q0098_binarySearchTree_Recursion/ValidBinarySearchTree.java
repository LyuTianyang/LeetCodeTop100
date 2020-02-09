package q0098_binarySearchTree_Recursion;

/**
在二叉搜索树中：
(01) 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
(02) 任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
(03) 任意节点的左、右子树也分别为二叉查找树。
(04) 没有键值相等的节点（no duplicate nodes）。
 */
class TreeNode
{
	int val;
	TreeNode parent;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val, TreeNode parent, TreeNode left, TreeNode right) {
		this.val = val;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}	 
}

public class ValidBinarySearchTree {
	/**
	给定一个二叉树，判断其是否是一个有效的二叉搜索树。

	假设一个二叉搜索树具有如下特征：

	节点的左子树只包含小于当前节点的数。
	节点的右子树只包含大于当前节点的数。
	所有左子树和右子树自身必须也是二叉搜索树。
	示例 1:
	
	输入:
	    2
	   / \
	  1   3
	输出: true
	示例 2:
	
	输入:
	    5
	   / \
	  1   4
	     / \
	    3   6
	输出: false
	解释: 输入为: [5,1,4,null,null,3,6]。
	     根节点的值为 5 ，但是其右子节点值为 4 。
		5
	   / \
	  3   7
	定义最小值和最大值, 3位置的最大值是5, 7位置的最小值是5
	二叉树，二叉搜索树，都可以为空
	 */
	public static boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		return helper(root, null, null);
    }

	private static boolean helper(TreeNode root, Integer min, Integer max) {
		if(root == null) return true;
		if(min != null && root.val<=min) return false;
		if(max != null && root.val>=max) return false;
		//左侧节点的最大值是根节点，右侧节点的最小值是根节点
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}
	
}
