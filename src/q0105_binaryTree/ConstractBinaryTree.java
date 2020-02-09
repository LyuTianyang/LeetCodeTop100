package q0105_binaryTree;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}


public class ConstractBinaryTree {
	
	/**
	 * 根据一棵树的前序遍历与中序遍历构造二叉树。
	 * 
	 * 注意: 你可以假设树中没有重复的元素。
	 * 
	 * 例如，给出
	 * 
	 * 前序遍历 preorder = [3,9,20,15,7] 首个元素是根节点
	 * 中序遍历 inorder = [9,3,15,20,7] 左边都是左子树，右边都是右子树
	 * 返回如下的二叉树：
	 * 
	 *  3
	   / \
	  9  20
	    /  \
	   15   7
	 */
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	    return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}

	public static TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
	    // preorder 为空，直接返回 null
	    if (p_start == p_end) {
	        return null;
	    }
	    int root_val = preorder[p_start];
	    TreeNode root = new TreeNode(root_val);
	    //在中序遍历中找到根节点的位置
	    int inIndex = 0;
	    for (int i = i_start; i < i_end; i++) {
	        if (root_val == inorder[i]) {
	        	inIndex = i;
	            break;
	        }
	    }
	    int leftNum = inIndex - i_start;
	    //递归的构造左子树
	    root.left = helper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, inIndex);
	    //递归的构造右子树
	    root.right = helper(preorder, p_start + leftNum + 1, p_end, inorder, inIndex + 1, i_end);
	    return root;
	}
	
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode result = buildTree(preorder, inorder);
		System.out.println(result);
	}
}
