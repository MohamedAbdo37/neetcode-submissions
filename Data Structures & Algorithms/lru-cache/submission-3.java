class LRUCache {

    class Node {
        int val;
        int key;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        public Node(int key, int val, Node prev) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = prev;
        }

        public Node(int key, int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    Map<Integer, Node> cash;

    Node head;
    Node tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.cash = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (this.cash == null)
            this.cash = new HashMap<>();

        if (this.cash.containsKey(key)) {
            Node used = this.cash.get(key);
            this.setRecent(used);
            return used.val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (this.cash.containsKey(key)) {

            Node n = this.cash.get(key);
            n.val = value;
            this.setRecent(n);

        } else if (this.size == this.capacity) {

            this.remove();
            this.setRecent(new Node(key, value));

            this.cash.put(key, tail);

        } else {

            size++;
            if (head == null) {
                this.head = new Node(key, value);
                this.tail = this.head;
            } else {
                this.setRecent(new Node(key, value));
            }

            this.cash.put(key, tail);
        }
    }

    private void remove() {
        this.cash.remove(this.head.key);
        Node tempNode = this.head;
        this.head = this.head.next;
        if (this.head != null)
            this.head.prev = null;
        tempNode.next = null;
    }

    private Node extract(Node n) {
        Node prev = n.prev;
        Node next = n.next;

        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;

        n.next = null;
        n.prev = null;

        return n;
    }

    private void setRecent(Node n) {

        if (n == this.tail)
            return;

        if (n == this.head) {
            this.head = this.head.next;
            this.head.prev = null;
        }

        if (this.cash.containsKey(n.key))
            this.extract(n);

        n.next = null;
        n.prev = this.tail;
        this.tail.next = n;
        this.tail = n;
    }

}