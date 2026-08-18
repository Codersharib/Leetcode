class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return max(nums, k);
    }

    public static int[] max(int[] arr,int k){
        Deque<Integer> q=new LinkedList<>();
        int[] ans=new int[arr.length-k+1];
        for (int i = 0; i < k-1; i++) {
            while(!q.isEmpty() && arr[i]>arr[q.peekLast()]){
                q.pollLast();
            }
            q.add(i);
        }
        int idx=0;
        for (int i = k-1; i < arr.length; i++) {
            while(!q.isEmpty() && arr[i]>arr[q.peekLast()]){
                q.pollLast();
            }
            q.addLast(i);
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            ans[idx++]=arr[q.peekFirst()];
        }
        return ans;
    }
}
