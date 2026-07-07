class Solution {
    public int maximalRectangle(char[][] matrix) {
        return maximal(matrix);
    }
    public static int maximal(char[][] matrix){
        
        int[] arr=new int[matrix[0].length];
        int area=0;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]=='1'){
                    arr[j]++;
                }
                else{
                    arr[j]=0;
                }
            }
            area=Math.max(area,Largest_Rectangle_in_Histogram(arr));
        }
        return area;
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