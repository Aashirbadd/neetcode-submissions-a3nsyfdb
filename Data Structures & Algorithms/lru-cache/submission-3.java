class LRUCache {

    private class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    int capacity;
    ListNode head;  // In front of real head        head <> x <> x <> tail
    ListNode tail;  // Behind real tail
    HashMap <Integer, ListNode> map;    // Maps key to ListNode

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);

        head.next = tail;
        tail.prev = head;   // head <> tail
    }
    
    public int get(int key) {
        // Obtain from map, and move to front of linkedlist
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            // Unlink old neighbours
            node.prev.next = node.next; // bfr: prev <> node <> next
            node.next.prev = node.prev; // aft: prev <> next
            // Link with new neighbours
            head.next.prev = node;      // head node < next
            node.next = head.next;      // head node <> next
            // Link neighbours to node
            head.next = node;           // head > node <> next
            node.prev = head;           // head <> node <> next
            
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            node.value = value;     
            this.get(key);          // Now move to the front
            return;
        }
        // Add to map.
        ListNode node = new ListNode(key, value);
        map.put(key, node);

        // Move to front of LL  // goal: head <> node <> next
        head.next.prev = node;  // head  node < next
        node.next = head.next;  // head  node <> next
        node.prev = head;       // head < node <> next
        head.next = node;       // head <> node <> next

        if (map.size() > capacity) {
            ListNode toRemove = tail.prev;
            //                  star: prev.prev <> toRem <> tail
            // rmv tail end     goal: prev.prev <> tail
            toRemove.prev.next = tail;     // prev.prev > tail
            tail.prev = toRemove.prev;     // prev.prev <> tail

            map.remove(toRemove.key);
        }
    }
}
// head<>2,2<>4,4<>1,8<>tail
