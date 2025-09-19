package DSA_Diary.daily.d_2025_09_19;

public class LeetCode_Sudoko_Solver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public static boolean solve(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='.'){
                    for(char c='1'; c<='9'; c++){
                        if (isvalid(board, i, j, c)){
                            board[i][j]=c;
                            if (solve(board)==true){
                                return true;
                            }else {
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isvalid(char[][] board, int row, int col, char c){
        for (int i = 0; i < 9; i++) {
            if (board[i][col]==c){
                return false;
            }
            if (board[row][i]==c){
                return false;
            }
            if (board[3*(row/3)+i/3][3*(col/3)+i%3]==c){
                return false;
            }
        }
        return true;
    }
}
