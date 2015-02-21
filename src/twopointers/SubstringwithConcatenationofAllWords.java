package twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiahan on 2/20/15.
 */
public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<>();
        if (S == null || S.length() == 0 || L == null || L.length == 0) {
            return result;
        }
        int len = L.length;
        int wordLen = L[0].length();
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (int i = 0; i < len; i++) {
            if (wordsMap.containsKey(L[i])) {
                wordsMap.put(L[i], wordsMap.get(L[i]) + 1);
            } else {
                wordsMap.put(L[i], 1);
            }
        }
        HashMap<String, Integer> found = new HashMap<String, Integer>();

        for (int i = 0; i <= S.length() - wordLen * len; i ++){
            found.clear();
            int j;
            for (j = 0; j < len; j++){
                int k = i + j * wordLen;
                String stub = S.substring(k, k + wordLen);
                if (!wordsMap.containsKey(stub)) break;
                if(!found.containsKey(stub)){
                    found.put(stub, 1);
                } else{
                    found.put(stub, found.get(stub) + 1);
                }
                if (found.get(stub) > wordsMap.get(stub)) break;
            }
            if (j == len) result.add(i);
        }
        return result;
    }
}
