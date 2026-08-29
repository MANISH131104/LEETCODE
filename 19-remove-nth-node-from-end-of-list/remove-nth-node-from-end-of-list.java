class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0);
        ListNode slow = ans;
        ListNode fast = ans;
        ans.next = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return ans.next;
    }
}