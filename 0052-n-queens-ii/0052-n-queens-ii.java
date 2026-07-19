class Solution {
    int count=0;
    public int totalNQueens(int n) {
        boolean[][] board=new boolean[n][n];
        count=0;
        queen2(board, 0, n);
        return count;
    }
    public void queen2(boolean[][] board,int cr,int tq){
        if(tq==0){
            count++;
            return ;
        }
        for(int i=0;i<board.length;i++) {
            if(isvalid(board,cr,i)){
                board[cr][i]=true;
                queen2(board, cr+1, tq-1);
                board[cr][i]=false;
            }
        }
    }
    public static boolean isvalid(boolean[][] board,int row,int col){
        // up
        int r=row;
        while(r>=0){
            if(board[r][col]==true) return false;
            r--;
        }
        // left di
        r=row;
        int c=col;
        while(c>=0 && r>=0){
            if(board[r][c]==true) return false;
            r--;
            c--;
        }
        // right di
        r=row;
        c=col;
        while(c<board[0].length && r>=0){
            if(board[r][c]==true) return false;
            r--;
            c++;
        }
        return true;
    }
}