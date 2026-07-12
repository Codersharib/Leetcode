class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return Maximum_window(nums, k);
    }

    public static int[] Maximum_window(int[] arr, int k) {
        int[] ans = new int[arr.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int j = 0;
        //1st window ka answer
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] > arr[dq.getLast()]) {
                dq.removeLast();
            }
            dq.add(i);
        }
        ans[j++] = arr[dq.getFirst()];
        for (int i = k; i < arr.length; i++) {
            // grow
            while (!dq.isEmpty() && arr[i] > arr[dq.getLast()]) {
                dq.removeLast();
            }
            dq.add(i);
            // shrink
            if (dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            // ans update
            ans[j++] = arr[dq.getFirst()];
        }
        return ans;
    }
}
