class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        return collision(asteroids);
    }

    public static int[] collision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            boolean self_kill=false;
            while (!st.isEmpty() && arr[i] < 0 && arr[st.peek()]>0) {
                if (arr[st.peek()] < -arr[i]) {
                    st.pop();
                } else if (arr[st.peek()] == -arr[i]) {
                    st.pop();
                    self_kill=true;
                    break;
                }
                else{
                    self_kill=true;
                    break;
                }
            }
            if(!self_kill){
                st.push(i);
            }
        }
        int[] ans=new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            ans[i--]=arr[st.pop()];
        }
        return ans;
    }
}