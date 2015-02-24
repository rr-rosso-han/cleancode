package stack;

import java.util.Stack;

/**
 * Created by jiahan on 2/21/15.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }

        String[] strs = path.split("/");
        Stack<String> s = new Stack<String>();
        for (String str : strs) {
            if (str.equals("..")) {
                if (!s.empty()) {
                    s.pop();
                }
            } else if (!str.equals(".") && !str.equals("")) {
                s.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.insert(0, s.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}
