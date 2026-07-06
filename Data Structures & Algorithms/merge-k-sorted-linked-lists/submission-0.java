

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        PriorityQueue<ListNode> min = new PriorityQueue<>((a,b)-> a.val-b.val);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null) {
                min.offer(lists[i]);
            }
        }
        while (!min.isEmpty()){
            ListNode top = min.poll();
            temp.next = top;
            temp = temp.next;
            if(top.next!=null){
                min.offer(top.next);
            }
        }
        return dummy.next;
    }
}
