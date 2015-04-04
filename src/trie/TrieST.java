package trie;

import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 2/12/15.
 */
public class TrieST<Value> {
    private static int R = 256;
    private TrieTreeNode root;
    private int N;          // number of keys in trie

    public Value get(String key) {
        TrieTreeNode x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.val;
    }

    private TrieTreeNode get(TrieTreeNode x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private TrieTreeNode put(TrieTreeNode x, String key, Value val, int d) {
        if (x == null) {
            x = new TrieTreeNode();
        }
        if (d == key.length()) {
            if (x.val == null) {
                N++;
            }
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    private int size(TrieTreeNode x) {
        if (x == null) return 0;
        int count = 0;
        if (x.val != null) {
            count++;
        }
        for (char c = 0; c < R; c++) {
            count += size(x.next[c]);
        }
        return count;
    }

    @Test
    public void keysTest() {
        String[] a = {"carbohydrate", "cart", "carburetor", "caramel","caribou",
                "carbonic", "cartilage","carbon", "carriage", "carton", "car", "carbonate"};
        for (int i = 0; i < a.length; i++) {
            put(a[i], (Value) Integer.valueOf(i));
        }

        System.out.println("====================keys()================");
        for (String key : keys()) {
            System.out.println(key);
        }
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    @Test
    public void keysWithPrefix() {
        String[] a = {"carbohydrate", "cart", "carburetor", "caramel","caribou",
                "carbonic", "cartilage","carbon", "carriage", "carton", "car", "carbonate"};
        for (int i = 0; i < a.length; i++) {
            put(a[i], (Value) Integer.valueOf(i));
        }
        System.out.println("=============keysWithPrefix()=============");
        for (String key : keysWithPrefix("carb")) {
            System.out.println(key);
        }
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new LinkedList<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(TrieTreeNode x, String pre, Queue<String> q) {
        if (x == null) return;
        if (x.val != null) q.offer(pre);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

    @Test
    public void keysThatMatch() {
        String[] a = {"carbohydrate", "cart", "carburetor", "caramel","caribou",
                "carbonic", "cartilage","carbon", "carriage", "carton", "car", "carbonate"};
        for (int i = 0; i < a.length; i++) {
            put(a[i], (Value) Integer.valueOf(i));
        }
        System.out.println("=============keysThatMatch()=============");
        for (String key : keysThatMatch("carb.n")) {
            System.out.println(key);
        }
    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new LinkedList<>();
        collect(root, "", pat, q);
        return q;
    }

    private void collect(TrieTreeNode x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.val != null) {
            q.offer(pre);
        }
        if (d == pat.length()) {
            return;
        }
        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(x.next[c], pre + c, pat, q);
            }
        }
    }

    @Test
    public void longestPrefixOf() {
        String[] a = {"carbohydrate", "cart", "carburetor", "caramel","caribou",
                "carbonic", "cartilage","carbon", "carriage", "carton", "car", "carbonate"};
        for (int i = 0; i < a.length; i++) {
            put(a[i], (Value) Integer.valueOf(i));
        }
        System.out.println("=============longestPrefixOf()=============");
        String b = longestPrefixOf("carrier");
        System.out.println(b);
    }
    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(TrieTreeNode x, String s, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    @Test
    public void shortestUniquePrefix() {
        System.out.println("=============shortestUniquePrefix()=============");
        String s = "cat";
        String[] c = {"dog", "be", "cut", "car", "cat"};
        for (int i = 0; i < c.length; i++) {
            put(c[i], (Value) Integer.valueOf(i));
        }
        String r = shortestUniquePrefix(s);
        assertEquals("failure - shortestUniquePrefix  of 'dog, be, cut, car, cat' not right",
                null, r);
        root = new TrieTreeNode();
        String[] b = {"dog", "be", "cut", "car"};
        for (int i = 0; i < b.length; i++) {
            put(b[i], (Value) Integer.valueOf(i));
        }
        r = shortestUniquePrefix(s);
        assertEquals("failure - shortestUniquePrefix  of 'dog, be, cut, car' not right",
                "cat", r);
        root = new TrieTreeNode();
        String[] a = {"dog", "be", "cut"};
        for (int i = 0; i < a.length; i++) {
            put(a[i], (Value) Integer.valueOf(i));
        }

        r = shortestUniquePrefix(s);
        assertEquals("failure - shortestUniquePrefix  of 'dog, be, cut' not right",
                "ca", r);
    }
    public String shortestUniquePrefix(String s) {
        int length = searchShort(root, s, 0, 0);
        if (length == 0) return null;
        return s.substring(0, length);
    }

    private int searchShort(TrieTreeNode x, String s, int d, int length) {
        if (x == null) return length + 1;
        if (x.val == null) length = d;
        if (d == s.length()) return 0;
        char c = s.charAt(d);
        return searchShort(x.next[c], s, d + 1, length);
    }
}

