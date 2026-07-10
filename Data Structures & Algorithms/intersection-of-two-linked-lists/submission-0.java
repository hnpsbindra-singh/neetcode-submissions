
  
public class Solution {
    public int length(ListNode head) {
        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int a = length(headA);
        int b = length(headB);
        
        if(a>b){
            int n = a-b;
            for (int i = 0; i < n; i++) {
                headA=headA.next;
            }
        } else if (a<b) {
            int n = b-a;
            for (int i = 0; i < n; i++) {
                headB=headB.next;
            }
        }
        
        while (headA!=null&&headB!=null){
            if (headA==headB){
                return headA;
            }
            headA=headA.next;
            headB = headB.next;
        }
        return null;
    }
}