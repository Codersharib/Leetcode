class Solution {
    public int maximalSquare(char[][] matrix) {
        return maximal_sq(matrix);
    }
    public static int maximal_sq(char[][] arr) {
        int max = 0;
        int[] arr2 = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '1') {
                    arr2[j]++;
                } else {
                    arr2[j] = 0;
                }
            }
            int ans = histogram_sq(arr2);
            max = Math.max(max, ans);
        }
        return max;
    }

    public static int histogram_sq(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int R = i;
                int h = arr[st.pop()];
                if (st.isEmpty()) {
                    int side = Math.min(h, R);
                    area = Math.max(area, side * side);
                } else {
                    int L = st.peek();
                    int x = R - L - 1;
                    int side = Math.min(x, h);
                    area = Math.max(area, side * side);
                }
            }
            st.push(i);
        }
        int r = arr.length;
        while (!st.isEmpty()) {
            int h = arr[st.pop()];
            if (st.isEmpty()) {
                int side = Math.min(h, r);
                area = Math.max(area, side * side);
            } else {
                int L = st.peek();
                int x = r - L - 1;
                int side = Math.min(x, h);
                area = Math.max(area, side * side);
            }
        }
        return area;
    }
}