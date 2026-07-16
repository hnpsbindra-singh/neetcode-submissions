
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
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0,0);
        tail= new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        delete(node);
        insertFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            delete(node);
            insertFront(node);
        }else {
            if(capacity==map.size()){
                Node node = tail.prev;
                delete(node);
                map.remove(node.key);
                Node add = new Node(key, value);
                map.put(key, add);
                insertFront(add);
            }else {
                Node add = new Node(key, value);
                map.put(key, add);
                insertFront(add);
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
