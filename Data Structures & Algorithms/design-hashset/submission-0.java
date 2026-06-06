class MyHashSet {

    private LinkedList<Integer>[] hashSet;
    private int capacity;

    public MyHashSet() {
        this.capacity = 997;
        this.hashSet = new LinkedList[capacity];
    }
    
    public void add(int key) {
        int hash = key % capacity;
        if(hashSet[hash] == null) {
            hashSet[hash] = new LinkedList<>();
        }
        if(!hashSet[hash].contains(key)) {
            hashSet[hash].add(key);
        }
    }
    
    public void remove(int key) {
        int hash = key % capacity;
        if(hashSet[hash] == null) {
            return;
        }
        hashSet[hash].remove((Integer) key);
    }
    
    public boolean contains(int key) {
        int hash = key % capacity;
        if(hashSet[hash] == null) {
            return false;
        }
        return hashSet[hash].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */