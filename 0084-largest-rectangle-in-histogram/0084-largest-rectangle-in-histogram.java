class Solution {
    public int largestRectangleArea(int[] heights) {
        return hist(heights);
    }
    public static int hist(int[] arr){
	    //Write Your Code here
		Stack<Integer> st=new Stack<>();
		int area=0;
		for(int i=0;i<arr.length;i++){
			while(!st.isEmpty() && arr[i]<arr[st.peek()]){
				int R=i;
				int h=arr[st.pop()];
				if(st.isEmpty()){
					area=Math.max(area,h*R);
				}
				else {
					int L=st.peek();
					area=Math.max(area,h*(R-L-1));
				}
			}
			st.push(i);
		}
		int r=arr.length;
		while(!st.isEmpty()){
				int h=arr[st.pop()];
				if(st.isEmpty()){
					area=Math.max(area,h*r);
				}
				else {
					int L=st.peek();
					area=Math.max(area,h*(r-L-1));
				}
		}
		return area;
	}
}