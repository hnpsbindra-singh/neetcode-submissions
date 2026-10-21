
class Solution {
    public ListNode reverse(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return newHead;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        ListNode secondList = reverse(middle);
        while (secondList!=null){
            ListNode first = temp;
            ListNode second = secondList;
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            temp = firstNext;
            secondList = secondNext;
        }
        
    }
}
