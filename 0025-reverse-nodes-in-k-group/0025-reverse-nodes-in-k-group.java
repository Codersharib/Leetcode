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
        ListNode p=head;
        ListNode dummy=new ListNode(0);
        ListNode t=dummy;
        Stack<Integer> st=new Stack<>();
        int i=0;
        while(p!=null){
            st.push(p.val);
            p=p.next;
            i++;
            if(i==k){
                while(!st.isEmpty()){
                    dummy.next=new ListNode(st.pop());
                    dummy=dummy.next;
                    head=head.next;
                }
                i=0;
            }
        }
        dummy.next=head;
        return t.next;
    }

}