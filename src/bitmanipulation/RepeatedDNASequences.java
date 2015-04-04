package bitmanipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiahan on 2/22/15.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result=new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Map<Integer,Integer> computed = new HashMap<>();
        Map<Character,Integer> dict = new HashMap<>();

        dict.put('A', 0);
        dict.put('C', 1);
        dict.put('G', 2);
        dict.put('T', 3);

        for(int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            int key = getKey(sub, dict);
            if(computed.containsKey(key)) {
                computed.put(key, computed.get(key)+1);
                if(computed.get(key) == 2) {
                    result.add(sub);
                }
            } else {
                computed.put(key, 1);
            }
        }
        return result;
    }

    public int getKey(String s, Map<Character, Integer> dict) {
        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int a = dict.get(c);
            result = a | result;
            result = result << 2;
        }
        return result;
    }
}
