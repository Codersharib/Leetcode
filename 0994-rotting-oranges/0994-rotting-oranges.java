class Solution {
    public int orangesRotting(int[][] grid) {
        return Rotten_Oranges(grid);
    }
    public int Rotten_Oranges(int[][] oranges) {
        int n = oranges.length;
        int m = oranges[0].length;
        int[][] visited = new int[n][m];
        Queue<rottenPair> q = new LinkedList<>();
        int c_fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (oranges[i][j] == 2) {
                    q.add(new rottenPair(i, j, 0));
                }
                if (oranges[i][j] == 1) {
                    c_fresh++;
                }
            }
        }
        int[] drow = {1, -1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        int t = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            // remove
            rottenPair rp = q.poll();
            t = Math.max(rp.tm, t);
            // ignnore
            // self work
            for (int i = 0; i < dcol.length; i++) {
                int r = rp.row + drow[i];
                int c = rp.col + dcol[i];
                // add unvisited frsh oranges
                if (r >= 0 && r < n && c >= 0 && c < m && visited[r][c] == 0 && oranges[r][c] == 1) {
                    q.add(new rottenPair(r, c, t + 1));
                    // mark visited
                    visited[r][c] = 2;
                    cnt++;
                }
            }
        }
        if (cnt != c_fresh) {
            return -1; 
        }else {
            return t;
        }
    }

    class rottenPair {

        int row, col, tm;

        public rottenPair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }
}