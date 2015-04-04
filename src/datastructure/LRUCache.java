package datastructure;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jiahan on 2/22/15.
 */
public class LRUCache {
    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    LinkedHashMap<Integer, Integer> map;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.get(0);
        return;
    }
    public LRUCache(int capacity) {
        MAX_CACHE_SIZE = capacity;
        //根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容，
        int size = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;
        //map = new LinkedHashMap(size, DEFAULT_LOAD_FACTOR, true);
        map = new LinkedHashMap(size, DEFAULT_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > LRUCache.this.MAX_CACHE_SIZE;
            }
        };
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        map.put(key, value);
    }
}
