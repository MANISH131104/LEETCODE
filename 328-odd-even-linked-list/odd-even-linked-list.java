class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        ListNode dummy1 = new ListNode(-1);
        ListNode temp1 = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode temp2 = dummy2;
        while(temp != null){
            temp1.next = temp;
            temp = temp.next;
            temp1 = temp1.next;
            temp2.next = temp;
            if(temp != null) temp = temp.next;
            temp2 = temp2.next;
        }
        temp1.next = dummy2.next;
        return dummy1.next;
    }
}