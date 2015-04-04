package string;

/**
 * Created by jiahan on 12/25/14.
 */
public class RemoveVowels {

    public String removeVowels(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        String p = "aeiou";
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (p.indexOf(Character.toLowerCase(a[i])) < 0) {
                result.append(a[i]);
            }
        }
        return result.toString();
    }
}
