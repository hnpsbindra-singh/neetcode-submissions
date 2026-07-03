/*class ListNode {

      int val;

      ListNode next;

      ListNode() {

      }
      ListNode(int val) {
          this.val = val;
      }

      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
  }*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        ListNode middle = findMiddle(head);
        ListNode newHead = reverse(middle.next);
        while (newHead!=null){
            if(head.val!=newHead.val){
                return false;
            }
            head=head.next;
            newHead=newHead.next;
        }
        return true;


    }

    private ListNode reverse(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode temp = head.next;
        temp.next=head;
        head.next=null;
        return newHead;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
}