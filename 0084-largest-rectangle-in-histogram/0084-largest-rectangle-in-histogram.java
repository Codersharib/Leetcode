class Solution {
    public int largestRectangleArea(int[] heights) {
        return Largest_Rectangle_in_Histogram(heights);
    }
    public static int Largest_Rectangle_in_Histogram(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int area = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int R = i;
                int h = heights[st.pop()];
                if (st.isEmpty()) {
                    area = Math.max(area, h * R);
                } else {
                    int L = st.peek();
                    area = Math.max(area, h * (R - L - 1));
                }
            }
            st.push(i);
        }
        int r = heights.length;
        while (!st.isEmpty()) {
            int h = heights[st.pop()];
            if (st.isEmpty()) {
                area = Math.max(area, h * r);
            } else {
                int l = st.peek();
                area = Math.max(area, h * (r - l - 1));
            }
        }
        return area;
    }
}