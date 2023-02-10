
public class Longest_Happy_Prefix_1392 {
    public String longestPrefix(String s) {
        int lps[] = new int[s.length()];
        int len = 0, i = 1;
        lps[0] = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return s.substring(0, lps[lps.length - 1]);
    }
}
