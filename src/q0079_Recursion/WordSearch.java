package q0079_Recursion;

public class WordSearch {
	/**
	给定一个二维网格和一个单词，找出该单词是否存在于网格中。
	单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
	同一个单元格内的字母不允许被重复使用。
	
	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	给定 word = "ABCCED", 返回 true.
	给定 word = "SEE", 返回 true.
	给定 word = "ABCB", 返回 false.
	 */
	public static boolean exist(char[][] board, String word) {
        if(board == null) return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        int idx = 0;
        for(int row=0; row<board.length; row++){
        	for(int col=0; col<board[0].length; col++){
        		if(helper(board, used, word.toCharArray(), idx, col, row)){
        			return true;
        		}
        	}
        }
        return false;
    }
	
	public static boolean helper(char[][] board, boolean[][] used, char[] word, int idx, int col, int row){
		//word里面的元素都被找到了，true
		if(idx == word.length) return true;
		//row或col出界， false
		if(row < 0 || row>= board.length || col<0 || col>= board[0].length) return false;
		//这个点被找过了
		if(used[row][col] == true || board[row][col] != word[idx]) return false;
		used[row][col] = true;
		//up
		boolean exist = helper(board, used, word, idx+1, col, row+1);
		if(exist) return true;
		//down
		exist = helper(board, used, word, idx+1, col, row-1);
		if(exist) return true;
		//right
		exist = helper(board, used, word, idx+1, col+1, row);
		if(exist) return true;
		//left
		exist = helper(board, used, word, idx+1, col-1, row);
		if(exist) return true;
		used[row][col] = false;
		return false;
	}
	
	public static void main(String[] args) {
		char[][] board  =  {{'A','B','C','E'},
							{'S','F','C','S'},
							{'A','D','E','E'}};
		boolean exist = exist(board,"ABCCED");
		System.out.println(exist);
	}
}
