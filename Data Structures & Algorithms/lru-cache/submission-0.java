

class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node top = map.get(key);
        delete(top);
        insertFront(top);
        return top.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node top = map.get(key);
            top.val = value;
            delete(top);
            insertFront(top);
        }else {
            if (capacity==map.size()){
                Node del = tail.prev;
                delete(del);
                map.remove(del.key);
                Node x = new Node(key, value);
                map.put(key, x);
                insertFront(x);
            }
            else {
                Node x = new Node(key, value);
                map.put(key, x);
                insertFront(x);
            }
        }

    }
    void delete(Node node){
        node.prev.next= node.next;
        node.next.prev = node.prev;
    }
    void insertFront(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
