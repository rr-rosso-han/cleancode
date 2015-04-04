package bfs;

import org.junit.Test;

import java.util.*;

/**
 * Created by jiahan on 2/22/15.
 */
public class WordLadder {

    @Test
    public void test() {
        String a = "hot";
        String c = "dog";
        Set<String> b = new HashSet<>();
        b.add("hot");
        b.add("dog");
        int s = ladderLength(a, c, b);
        return;
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 2;
        }
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Map<String,Integer> passed = new HashMap<String,Integer>();
        queue.offer(start);
        passed.put(start, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int steps = passed.get(word);
            if (word.equals(end)) {
                return steps + 1;
            }
            for (int j = 0; j < word.length(); j++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (word.charAt(j) == c) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(j, c);
                    if(sb.toString().equals(end)) {
                        return steps + 1;
                    }

                    if(dict.contains(sb.toString())
                            && !passed.containsKey(sb.toString())) {
                        queue.add(sb.toString());
                        passed.put(sb.toString(), steps + 1);
                    }
                }
            }
        }
        return 0;
    }

    public int ladderLength2(String start, String end, Set<String> dict) {
        if (start == null || end == null || start.equals(end)
                || start.length() != end.length()) {
            return 0;
        }
        if (start.equals(end)) {
            return 2;
        }
        Queue<String> queue = new LinkedList<String>();
        Map<String,Integer> dist = new HashMap<String,Integer>();
        queue.add(start);
        dist.put(start, 1);
        while(!queue.isEmpty()) {
            String head = queue.poll();
            int headDist = dist.get(head);
            //start to replace with a~z
            for(int i = 0 ; i < head.length(); i++) {
                for(char j='a'; j<'z'; j++) {
                    if(head.charAt(i) == j) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(head);
                    sb.setCharAt(i, j);
                    if(sb.toString().equals(end)) {
                        return headDist + 1;
                    }
                    if(dict.contains(sb.toString())
                            && !dist.containsKey(sb.toString())) {
                        queue.add(sb.toString());
                        dist.put(sb.toString(), headDist + 1);
                    }
                }
            }
        }
        return 0;
    }
}
