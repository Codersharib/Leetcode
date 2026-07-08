class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return Next_Greater(nums1,nums2);
    }
    public static int[] Next_Greater(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty() && nums2[i] > nums2[st.peek()]) {
                ans[st.pop()] = nums2[i];
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    res[i] = ans[j];
                }
            }

        }

        return res;
    }
}