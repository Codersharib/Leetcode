class Solution {
    public int[] nextGreaterElements(int[] nums) {
        return NGE2(nums);
    }
    public static int[] NGE2(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        int turn=0;
        for (int i = 0; i< 2*arr.length; i++) {
            int idx=i%arr.length;
            while (!st.isEmpty() && arr[idx] > arr[st.peek()]) {
                ans[st.pop()] = arr[idx];
            }
            if(i<arr.length){
                st.push(idx);
            }

        }
        while(!st.empty()){
            ans[st.pop()]=-1;
        }
        return ans;
    }
}