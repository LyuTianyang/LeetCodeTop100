package q0114_binaryTree;

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
/**
	给定一个二叉树，原地将它展开为链表。
	
	例如，给定二叉树
	
	    1
	   / \
	  2   5
	 / \   \
	3   4   6
	将其展开为：
	
	1
	 \
	  2
	   \
	    3
	     \
	      4
	       \
	        5
	         \
	          6

 */
public class FlattenBinaryTreeToLinkedList {
	/**
	 * 可以发现展开的顺序其实就是二叉树的先序遍历。算法和 94 题中序遍历的 Morris 算法有些神似，我们需要两步完成这道题。

		1.将左子树插入到右子树的地方
		2.将原来的右子树接到左子树的最右边节点
		3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
			1
		   / \
		  2   5
		 / \   \
		3   4   6
		
		//先找到左子树最右边的节点pre(4)，将根节点的右节点接到pre下
		 
		    1
		   / 
		  2   
		 / \   
		3   4
		   	 \
		   	  5
		   	   \
		   	    6
		   	      
		//将原来的右子树接到左子树的最右边节点
		    1
		     \
		      2          
		     / \          
		    3   4  
		         \
		          5
		           \
		            6
		            
		 //将 2 的左子树插入到右子树的地方
		    1
		     \
		      2          
		       \          
		        3       4  
		                 \
		                  5
		                   \
		                    6   
		        
		 //将原来的右子树接到左子树的最右边节点
		    1
		     \
		      2          
		       \          
		        3      
		         \
		          4  
		           \
		            5
		             \
		              6         
		  
		  
	 */
	public static void flatten1(TreeNode root) {
        while(root != null){
        	//左子树为null， 直接考虑下一个节点
        	if(root.left == null){
        		root = root.right;
        	}else{
        		//找到左子树最右边的节点
        		TreeNode pre = root.left;
        		while(pre.right !=null){
        			pre = pre.right;
        		}
        		//将原来右子树接到左子树的最右边节点
        		pre.right = root.right;
        		
        		root.right = root.left;
        		root.left = null;
        		
        		root = root.right;
        	}
        }
    }
	
	public static void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<TreeNode> list = new ArrayList<>();
        
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		flatten2(root);
		System.out.println(root);
	}
}
