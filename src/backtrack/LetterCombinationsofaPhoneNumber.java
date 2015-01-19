package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 1/19/15.
 */
public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        if (digits == null || digits.length() == 0) {
            result.add(path.toString());
            return result;
        }
        String[] padLetters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        letterCombinationsHelper(result, path, padLetters, digits, 0);
        return result;
    }

    private void letterCombinationsHelper(List<String> result,
                                          StringBuffer path,
                                          String[] padLetters,
                                          String digits,
                                          int pos) {
        if (path.length() == digits.length()) {
            result.add(new String(path));
            return;
        }
        for (int i = pos; i < digits.length(); i++) {
            Character x = digits.charAt(i);
            if (x.equals('0') || x.equals('1')) {
                continue;
            }
            String tmp = padLetters[Integer.parseInt(x.toString())];
            for (int j = 0; j < tmp.length(); j++) {
                path.append(tmp.charAt(j));
                letterCombinationsHelper(result, path, padLetters, digits, i + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
