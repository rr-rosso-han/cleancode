package string;

/**
 * Created by jiahan on 12/15/14.
 */
public class ValidNumber {

    /*
    *
    * s1. Leading whitespaces (optional).
    * s2. Plus (+) or minus (–) sign (optional).
    * s3. Number.
    * s4. Optional trailing whitespaces (optional).
    * */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0;
        int n = s.length();
        //s1. Leading whitespaces (optional).
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        //s2. Plus (+) or minus (–) sign (optional).
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        //s3. Number.
        boolean isNumeric = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        //s4. Optional trailing whitespaces (optional).
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        return isNumeric && i == n;
    }

    public boolean isNumberWithExponent(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0;
        int n = s.length();
        //s1
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        //s2
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        //s3
        boolean isNumeric = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        //exponent part
        if (isNumeric && i < n && s.charAt(i) == 'e') {
            i++;
            isNumeric = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        //s4
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        return isNumeric && i == n;
    }
}
