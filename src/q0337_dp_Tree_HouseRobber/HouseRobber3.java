package q0337_dp_Tree_HouseRobber;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class HouseRobber3 {
	/**
	在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 
	除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 
	如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

	计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
	
	示例 1:
	
	输入: [3,2,3,null,3,null,1]
	
	     3
	    / \
	   2   3
	    \   \ 
	     3   1
	
	输出: 7 
	解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
	示例 2:
	
	输入: [3,4,5,1,3,null,1]
	
	     3
	    / \
	   4   5
	  / \   \ 
	 1   3   1
	
	输出: 9
	解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.

	 */
	
	/*
	首先要明确相邻的节点不能偷，也就是爷爷选择偷，儿子就不能偷了，但是孙子可以偷
	二叉树只有左右两个孩子，一个爷爷最多2个儿子,4个孙子
	性能最低的解法
	 */
	public int rob1(TreeNode root) {
        if(root == null) return 0;
        int max = root.val;
        //偷下下层的节点
        if(root.left != null){
        	max += (rob1(root.left.left) + rob1(root.left.right));
        }
        if(root.right != null){
        	max += (rob1(root.right.left)+ rob1(root.right.right));
        }
        
        return Math.max(max, rob1(root.left)+rob1(root.right));
    }
	
	/*
	我们换一种办法来定义此问题
	每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
	
	当前节点选择偷时，那么两个孩子节点就不能选择偷了
	当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
	我们使用一个大小为2的数组来表示 int[] res = new int[2] 0代表不偷，1代表偷
	任何一个节点能偷到的最大钱的状态可以定义为
	
	当前节点选择不偷: 当前节点能偷到的最大钱数 = 左儿子能偷到的钱 + 右儿子能偷到的钱
	当前节点选择偷: 当前节点能偷到的最大钱数 = 左孙子的钱 + 右孙子的钱 + 当前节点的钱数
	表示为公式如下
	
	root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
	root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
	 */
	public int rob2(TreeNode root) {
		int[] res = robHelper(root);
		return Math.max(res[0], res[1]);
	}
	
	public int[] robHelper(TreeNode root) {
		if(root == null) return new int[2];
		int[] res = new int[2];
		
		int[] left = robHelper(root.left);
		int[] right = robHelper(root.right);
		
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = left[0] + right[0] + root.val;
		
		return res;
	}
	
}
