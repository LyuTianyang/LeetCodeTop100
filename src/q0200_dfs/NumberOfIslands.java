package q0200_dfs;

public class NumberOfIslands {
	/**
	给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
	示例 1:
	输入:
	11110
	11010
	11000
	00000
	输出: 1
	
	示例 2:
	输入:
	11000
	11000
	00100
	00011
	输出: 3
	
	DFS: Depth-First-Search
	BFS: Breadth-First-Search
	 */
	public static int numIslands(char[][] grid) {
        int res = 0;
		int m = grid.length;
        int n = grid[0].length;
        if(grid == null || m == 0 || n == 0) return res;
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(grid[i][j] == '1'){
        			 dfs(grid, i, j);
        			 res++;
        		}
        	}
        }
        return res;
    }

	public static void dfs(char[][] grid, int i, int j) {
		int m = grid.length;
        int n = grid[0].length;
		if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0') return;
		grid[i][j] = '0';
		dfs(grid, i, j+1);
		dfs(grid, i, j-1);
		dfs(grid, i+1, j);
		dfs(grid, i-1, j);
	}
	
	public static void main(String[] args) {
		char[][] grid  =  {{'1','1','0','0','0'},
							{'1','1','0','0','0'},
							{'0','0','1','0','0'},
							{'0','0','0','0','0'},
							{'0','0','0','1','1'}};
		int res = numIslands(grid);
		System.out.println(res);
	}
}