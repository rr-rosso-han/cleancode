package dp;

import java.util.Arrays;

/**
 * Created by jiahan on 2/19/15.
 */
public class ScrambleString {
    /*
    * 动态规划。
    * 定义F[i][j][k]，
    * 当F[i][j][k]=true时，表示S1[i..i+k-1] == S2[j..j+k-1]。
    * 用白话表达：F[i][j][k]记录的是S1从i开始k个字符与S2从j开始k个字符是否为Scramble String。

    * 最简单的情况为k=1时，即S1[i]与S2[j]是否为Scramble String。
    * 因此F[i][j][1] = S1[i] == S2[j]。

    * 当K=2时，
    * F[i][j][2] = (F[i][j][1] && F[i+1][j+1][1]) || (F[i][j+1][1] && F[i+1][j][1])。
    * F[i][j][1] && F[i+1][j+1][1]表达的是 S1[i] == S2[j] && S1[i+1]==S2[j+1]（例如：“AC”和“AC”），如果这个条件满足，那么S1[i..i+1]与S2[j..j+1]自然为Scramble String，即F[i][j][2] = true。
    * F[i][j+1][1] && F[i+1][j][1]表达的是S1[i+1] == S2[j] && S1[i] == S2[j + 1] （例如： “AB”和“BA”），同样如果该条件满足，F[i][j][2] = true。

    * 当K为更大的数时，同递归算法一样，我们需要枚举分割点，假设左边长度为l，即S[i..i+l-1]，右边长度为k-l，即S[i+l..i+k-1]。
    * 同样存在两种情况，S1左 = S2左 && S1右 = S2右 或者 S1左 = S2右 && S1右 = S2左。
    * */
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.length()==1 && s2.length()==1){
            return s1.charAt(0) == s2.charAt(0);
        }

        // 排序后可以通过
        char[] s1ch = s1.toCharArray();
        char[] s2ch = s2.toCharArray();
        Arrays.sort(s1ch);
        Arrays.sort(s2ch);
        if(!new String(s1ch).equals(new String(s2ch))){
            return false;
        }

        boolean [][][] res =  new boolean[s1.length()][s2.length()][s1.length()+1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                //k == 1 if s1[i] == s2[j] res is true
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= s1.length(); len++) {
            for (int i = 0; i < s1.length() - len + 1; i++) {
                for (int j = 0; j < s2.length() - len + 1; j++) {
                    for (int k = 1; k < len; k++) {
                        res[i][j][len] |= res[i][j][k]
                                && res[i + k][j + k][len - k]
                                || res[i][j + len - k][k]
                                && res[i + k][j][len - k];
                    }
                }
            }
        }
        return res[0][0][s1.length()];
    }
}
