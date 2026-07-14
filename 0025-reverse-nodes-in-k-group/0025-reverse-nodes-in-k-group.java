/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> st = new Stack<>();
        ListNode dummy = new ListNode();
        ListNode start = head;
        ListNode temp = dummy;
        while (head != null) {
            st.push(head);
            head = head.next;
            if (st.size() == k) {
                while (!st.isEmpty()) {
                    dummy.next = st.pop();
                    dummy = dummy.next;
                }
                start = head;
                dummy.next = null;
            }
        }
        if (!st.isEmpty()) {
            dummy.next = start;
        }

        return temp.next;
    }

}