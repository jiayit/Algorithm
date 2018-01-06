package leetcode5;

class Solution {
    public static String longestPalindrome(String s) {
        int N = s.length();
        int p = 0, q =0;
        int length = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1;j < N; j++) {
                int half = (j - i)/2 ;
                int m;
                for (m = 0; m < half + 1; m++) {
                    if (s.charAt(i + m) != s.charAt(j - m)) {
                        break;
                    }

                }
                if (m == half + 1) {
                    length = Math.max(length, j - i);
                    if (length == j - i) {
                        p = i;
                        q = j;
                    }
                }
            }

        }
        return s.substring(p, q + 1);
    }
    public static String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] substring = new boolean[n][n];
        int length = 0, p = 0, q = 0;
        for (int i = n; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                substring[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || substring[i + 1][j - 1]);

                if (substring[i][j] && j - i + 1 > length) {
                    length = j - i + 1;
                    p = i;
                    q = j;
                }
            }

        }
        return s.substring(p, q + 1);
    }

    public static void main(String[] args) {
        String string = "babaddtattarrattatddetartrateedredividerb";
        String string1 = "abab";
        System.out.println(longestPalindrome1(string));
    }
}