class Solution {
    public void solveSudoku(char[][] board) {
        print(board,0,0);
    }
    public static boolean print(char[][] grid,int row,int col){
        if(col==9){
            row++;
            col=0;
        }
        if(row==9){
            return true;
        }
        if(grid[row][col]!='.'){
            return print(grid, row, col+1);
        }
        else{
            for(char i='1';i<='9';i++) {
                if(isitsafe(grid,row,col,i-'0')){
                    grid[row][col]=i;
                    boolean solver=print(grid, row, col+1);
                    if(solver){
                        return solver;
                    }
                    grid[row][col]='.';

                }
            }
        }
        return false;
    }
    public static boolean isitsafe(char[][] grid,int row,int col,int val){
        // row
        for(int i=0;i<grid.length;i++) {
            if(grid[row][i]-'0'==val) return false;
        }
        // col
        for(int i=0;i<grid.length;i++) {
            if(grid[i][col]-'0'==val) return false;
        }
        // 3*3 matrix
        int r=row-row%3;
        int c=col-col%3;
        for(int i=r;i<r+3;i++) {
            for(int j=c;j<c+3;j++) {
                if(grid[i][j]-'0'==val) return false;
            }
        }
        return true;
    }
}