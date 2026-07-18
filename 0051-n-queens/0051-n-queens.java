class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<String> ll = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        n_queen_(board, 0, n, ll, res);
        return res;
    }
    public static void n_queen_(boolean[][] board, int row, int tq, List<String> ll, List<List<String>> res) {
        if (tq == 0) {
            res.add(new ArrayList<>(ll));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isPossible(board, row, i)) {
                board[row][i] = true;
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < board.length; k++) {
                    sb.append(k == i ? 'Q' : '.');
                }
                ll.add(sb.toString());
                n_queen_(board, row + 1, tq - 1, ll, res);
                ll.remove(ll.size() - 1);
                board[row][i] = false;
            }

        }
    }

    public static boolean isPossible(boolean[][] board, int row, int col) {
        // up
        int r = row;
        while (r >= 0) {
            if (board[r][col] == true) {
                return false;
            }
            r--;
        }
        // left diagonal
        r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == true) {
                return false;
            }
            r--;
            c--;
        }
        // right diagonal
        r = row;
        c = col;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c] == true) {
                return false;
            }
            r--;
            c++;
        }
        return true;

    }
}