package q0221_dp;

public class MaximalSquare {
	/**
	在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
	
	输入:
	1 0 1 0 0
	1 0 1 1 1
	1 1 1 1 1
	1 0 0 1 0
	输出: 4
	
	dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
	 */
	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m+1][n+1];
		int max = 0;
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(matrix[i-1][j-1] == '1'){
					dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1])+1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max*max;
    }
	
	public static int maximalSquare1(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < col; i++) {
        	dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                	dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1])+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
	
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},
						   {'1','0','1','1','1'},
						   {'1','1','1','1','1'},
						   {'1','0','0','1','1'}};
		int result = maximalSquare(matrix);
		System.out.println(result);
	}
}
