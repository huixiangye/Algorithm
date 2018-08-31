package leetcode.HashMap.如何去实现一个HashMap或者HashSet;

/**
 * Created by yehuixiang on 8/30/18.
 */
public class DesignHashSet_705 {
    private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;
    /** Initialize your data structure here. */
    public DesignHashSet_705() {
        table = new boolean[buckets][];
    }

    public int hash(int key) {
        return key % buckets;
    }

    public int pos(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int hashkey = hash(key);

        if(table[hashkey] == null){
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true;
    }

    public void remove(int key) {
        int hashkey = hash(key);

        if (table[hashkey] != null)
            table[hashkey][pos(key)] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

