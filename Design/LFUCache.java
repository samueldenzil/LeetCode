// https://leetcode.com/problems/lfu-cache/
package Design;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    private int capacity;
    private int min;

    Map<Integer, Integer> keyValueMap;
    Map<Integer, Integer> keyFrequencyMap;
    // Why ordered so that in case of collision least recently used is
    // keyToBeEvicteded
    Map<Integer, LinkedHashSet<Integer>> frequencyKeysMap;

    public LFUCache(int capacity) {
        this.min = 1;
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
        keyFrequencyMap = new HashMap<>();
        frequencyKeysMap = new HashMap<>();
        frequencyKeysMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!keyValueMap.containsKey(key)) {
            return -1;
        }

        int freq = keyFrequencyMap.get(key);
        // remove the key from the previous frequency
        frequencyKeysMap.get(freq).remove(key);

        if (freq == min && frequencyKeysMap.get(freq).size() == 0) {
            min++;
        }
        if (!frequencyKeysMap.containsKey(freq + 1)) {
            frequencyKeysMap.put(freq + 1, new LinkedHashSet<>());
        }
        // add the key to corresponding to freq+1
        frequencyKeysMap.get(freq + 1).add(key);
        // increment the frequency by one for the current key
        keyFrequencyMap.put(key, freq + 1);

        return keyValueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            get(key);
            return;
        }

        if (keyValueMap.size() >= capacity) {
            int keyToBeEvicted = frequencyKeysMap.get(min).iterator().next();
            frequencyKeysMap.get(min).remove(keyToBeEvicted);
            keyValueMap.remove(keyToBeEvicted);
            keyFrequencyMap.remove(keyToBeEvicted);
        }
        // key is not present in the keyValueMap
        keyValueMap.put(key, value);
        keyFrequencyMap.put(key, 1);
        frequencyKeysMap.get(1).add(key);
        min = 1;
    }

    public static void main(String[] args) {
        // cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */