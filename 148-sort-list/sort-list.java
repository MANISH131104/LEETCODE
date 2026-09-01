class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeList(l1,l2);
    }
    ListNode mergeList(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (head1 != null && head2 != null) {

            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }

            temp = temp.next;
        }
        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }

    return dummy.next;
    }
}