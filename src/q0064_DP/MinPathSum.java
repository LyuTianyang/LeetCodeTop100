package q0064_DP;

public class MinPathSum {
	/**
	给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
	说明：每次只能向下或者向右移动一步。
	示例:
	输入:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	输出: 7
	解释: 因为路径 1→3→1→1→1 的总和最小。
	 */
	/*
	状态: [m][n]
	init:
	方程: min(up,left)+num
	result 右下角的值 
	*/
	public static int minPathSum(int[][] grid) {
		if(grid==null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        //状态: [m][n]
        int[][] dp = new int[m][n];
        //初始化
        dp[0][0] = grid[0][0];
        for(int i=1; i<m; i++){
        	dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int j=1; j<n; j++){
        	dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        //方程：dp[i][j] = min(dp[i][j-1],dp[i-1][j])+grid[i][j]
        for(int i=1; i<m; i++){
        	for(int j=1; j<n; j++){
        		dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
        	}
        }
        return dp[m-1][n-1];
    }
	
	
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},
						{1,5,1},
						{4,2,1}};
		
		int result = minPathSum(grid);
		System.out.println(result);
	}
	
}
