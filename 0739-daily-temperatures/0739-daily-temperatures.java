class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        return daily_temp(temperatures);
    }
    public static int[] daily_temp(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                int idx=st.pop();
                if(ans[idx]==0){
                    ans[idx]=i-idx;
                }
            }
            st.push(i);
        }
        return ans;
    }
}