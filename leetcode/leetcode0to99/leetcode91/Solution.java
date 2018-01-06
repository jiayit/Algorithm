package leetcode91;

public class Solution {
    // wrong answer : deplicate num
    public static int numDecodings(String s) {
        int sum = 0;
        int len = s.length();
        if (len == 1) {
            if (Integer.parseInt(s) == 0) {
                sum = 0;
            }
            else {
                sum = 1;
            }

        }
        else if (len == 2 && s.equals("00")) {
            sum = 0;
        }
        else if (len == 2) {
            int x = Integer.parseInt(s);
            if (x == 10 || x == 20) {
                sum = 1;
            }
            else if (s.charAt(1) == '0') {
                sum = 0;
            }
            else if (x <= 26) {
                sum = 2;
            }
            else {
                sum = 1;
            }
        }
        else if (len == 3 && s.charAt(0) == s.charAt(2)) {
            sum = 3;
        }
        else {
            for (int i = 0; i < len - 1; i++) {
                int sum1 = numDecodings(s.substring(0, i + 1));
                int sum2 = numDecodings(s.substring(i + 1, len));
                sum = sum + sum1 * sum2;

            }
        }
        return sum;
    }

    // DP danamic programming
    public static int numDecodings1(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int num1 = Integer.parseInt(s.substring(i - 1, i));
            int num2 = Integer.parseInt(s.substring(i - 2, i));
            if (num1 > 0 && num1 < 10) {
                dp[i] = dp[i] + dp[i - 1];
            }
            if (num2 <= 26 && num2 >= 10) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[len];
    }
    public static void main (String[] args) {
        String string = "00";
        System.out.println(numDecodings1(string));
    }
}
