package q0096_binarySearchTree_DP;

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

public class UniqueBinarySearchTrees {
	/**
	给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

	示例:
	输入: 3
	输出: 5
	解释:
	给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	 n = 3
	 root:1 left:0 right:2  f(0)*f(2);
	 root:2 left:1 right:1  f(1)*f(1);
	 root:3 left:2 right:0  f(2)*f(0);
	 
	 f(n) = f(0)*f(n-1) + f(1)*f(n-2)+ ... + f(n-2)*f(1) + f(n-1)*f(0)
	 */
	public static int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        for(int i=1; i<=n; i++){
        	//j表示左子节点
        	for(int j=0; j<i; j++){
        		//i-j-1表示右子节点，1是根节点 
        		//f(3) = f(0)*f(3-0-1) + f(1)*f(3-1-1) + f(2)*f(3-2-1)
        		//f(3) = f(0)*f(2) + f(1)*f(1) + f(2)*f(0)
        		res[i] += res[j]*res[i-j-1];
        	}
        }
        return res[n];
    }
	
	
	public static void main(String[] args) {
		int res = numTrees(5);
		System.out.println(res);
	}
}
