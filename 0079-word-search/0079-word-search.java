class Solution {
    public boolean exist(char[][] board, String word) {
        
            int[][] visited = new int[board.length][board[0].length];
            boolean found = false;
            for (int i = 0; i < board.length && !found; i++) {
                for (int j = 0; j < board[0].length && !found; j++) {
                    found = wordSearch(board, word, i, j, 0, visited);
                }
            }
            return found;
    }

    public static boolean wordSearch(char[][] board, String word, int cr, int cc, int i, int[][] visited) {
            if (i== word.length()) {
                return true;
            }
            if (cr >= board.length || cc >= board[0].length || cr < 0 || cc < 0 || visited[cr][cc] == 1 || board[cr][cc] != word.charAt(i)) {
                return false;
            }

            int[] row = {0, 1, 0, -1};
            int[] col = {1, 0, -1, 0};

            visited[cr][cc] = 1;
            boolean res=false;
            for (int j = 0; j < col.length; j++) {
                int r = cr + row[j];
                int c = cc + col[j];
                if(wordSearch(board, word, r, c, i+1, visited)){
                    res=true;
                    break;
                }
            }
            visited[cr][cc] = 0;
            return res;
        }
}