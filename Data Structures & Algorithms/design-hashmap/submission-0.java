class MyHashMap {

    private class HashMapNode {
        int key;
        int value;
        HashMapNode next;

        public HashMapNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private HashMapNode[] bucket;
    private int capacity;

    public MyHashMap() {
        this.capacity = 997;
        this.bucket = new HashMapNode[capacity];
    }
    
    private int getHash(int key) {
        return key % capacity;
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);

        if(bucket[hash] == null) 
            bucket[hash] = new HashMapNode(key, value);
        else {
            HashMapNode previous = null;
            HashMapNode node = bucket[hash];
            while(node != null) {
                if(node.key == key) {
                    node.value = value;
                    return;
                }
                previous = node;
                node = node.next;
            }
                
            previous.next = new HashMapNode(key, value);
        }  
    }
    
    public int get(int key) {
        int hash = getHash(key);

        HashMapNode node = bucket[hash];

        while(node != null) {
            if(node.key == key)
                return node.value;
            else
                node = node.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        HashMapNode previous = null;
        HashMapNode node = bucket[hash];

        while(node != null) {
            if(node.key == key) {
                if(previous == null)
                    bucket[hash] = node.next;
                else 
                    previous.next = node.next;
                return;
            } else {
                previous = node;
                node = node.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */