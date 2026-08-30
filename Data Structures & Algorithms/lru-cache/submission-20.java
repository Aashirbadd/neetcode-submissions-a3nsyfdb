class LRUCache {
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;
        
        public ListNode (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    ListNode head;
    ListNode tail;

    HashMap<Integer, ListNode> map;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);

        this.head.prev = tail;
        this.tail.next = head;

        // tail <> head
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode fetchedNode = map.get(key);
            removeNode(fetchedNode);
            addNodeToTip(fetchedNode);

            return fetchedNode.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // If the key already exists
        if (map.containsKey(key)) {
            ListNode existingNode = map.get(key);
            existingNode.value = value;                 // Update value
            removeNode(existingNode);
            addNodeToTip(existingNode);
        }
        else {
            // Remove the tip of tail if size exceeds capacity...
            if (map.size() == capacity) {
                ListNode toRemove = tail.next;
                removeNode(toRemove);
                map.remove(toRemove.key);
                // Before: tail <> toRemove <> neighbor
                // After:  tail <> neighbor
            }
            // Create the new ListNode & add it to the map
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);

            // Put it at the tip of LinkedList, right behind head
            addNodeToTip(newNode);
            // Before: oldTip <> head
            // After: oldTip <> newNode <> head
        }
    }
    private void addNodeToTip(ListNode toAdd) {
        // Before: tip <> head
        // After: tip <> toAdd <> head
        ListNode tip = head.prev;
        tip.next = toAdd;
        toAdd.prev = tip;

        toAdd.next = head;
        head.prev = toAdd;
    }

    private void removeNode(ListNode toRemove) {
        // Before: behind <> toRemove <> forward
        // After:  behind <> forward
        ListNode behind = toRemove.prev;
        ListNode forward = toRemove.next;

        behind.next = forward;
        forward.prev = behind;
    }
}

// Okay LRU Cache... This is an actual useful question...