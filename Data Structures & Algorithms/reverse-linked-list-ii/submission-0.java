


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;

        for (int i = 1; i < left; i++) {
            temp = temp.next;
        }

        ListNode nh = temp.next;
        ListNode nt = nh;
        ListNode next = head;
        for (int i = left; i < right ; i++) {
            nt = nt.next;
        }
        next = nt.next;
        temp.next = reverse(nh,nt);
        nh.next= next;
        return dummy.next;

    }

    private ListNode reverse(ListNode nh, ListNode nt) {
        if(nh==nt){
            return nh;
        }
        ListNode newHead = reverse(nh.next, nt);
        ListNode temp = nh.next;
        temp.next=nh;
        nh.next=null;
        return newHead;
    }
}