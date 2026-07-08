class Solution {
    public boolean find132pattern(int[] nums) {
        return pattern132(nums);
    }
    public static boolean pattern132(int[] arr){
        Stack<Integer> st=new Stack<>();
        int third=Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--) {
            if(arr[i]<third){
                return true;
            } 
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                third=arr[st.pop()];
            }
            st.push(i);
        }
        return false;
        
    }
}