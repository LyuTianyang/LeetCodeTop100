package q0240;

public class Search2DMatrix1 {
	/**
	编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

	每行中的整数从左到右按升序排列。
	每行的第一个整数大于前一行的最后一个整数。
	示例 :
	
	输入:
	matrix = [
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	target = 3
	输出: true
	
	target = 13
	输出: false
	 */
	
	//使用两个二分法,先根据每一行的最后一个元素找到target在哪一行
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int startRow = 0;
		int endRow = matrix.length-1;
		int endCol = matrix[0].length-1;
		int row = -1;
		while(startRow+1<endRow){
			int mid = startRow+(endRow-startRow)/2;
			if(matrix[mid][endCol]==target) return true;
			if(matrix[mid][endCol]<target) startRow = mid;
			else endRow = mid;
		}
		if(matrix[startRow][endCol] >= target) row=startRow;
		else if(matrix[endRow][endCol] >= target) row=endRow;
		else return false;
		
		int start = 0;
		int end = endCol;
		while(start+1 < end){
			int mid = start+(end-start)/2;
			if(matrix[row][mid] == target) return true;
			if(matrix[row][mid] < target) start = mid;
			else end = mid;
		}
		if(matrix[row][start] == target || matrix[row][end] == target) return true;
		else return false;
    }
	
	public static boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int row = matrix.length-1;
        int col = 0;
        while(row>=0 && col<matrix[0].length){
        	if(matrix[row][col] > target){
        		row--;
        	}else if(matrix[row][col] < target){
        		col++;
        	}else{
        		return true;
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {
		        		  {1,   3,  5,  7},
		        		  {10, 11, 16, 20},
		        		  {23, 30, 34, 50}
		        		};
		boolean res = searchMatrix1(matrix, 20);
		System.out.println(res);
	}
}
