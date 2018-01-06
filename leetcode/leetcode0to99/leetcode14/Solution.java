package leetcode14;

import java.util.Arrays;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length  = strs.length;
        Arrays.sort(strs);
        String prefix = "";
        int pre = 1000;
        for (int i = 0; i < length; i++) {
            if (pre > strs[i].length()) {
                pre = strs[i].length();
            }
        }
        for (int j = 1; j <= pre; j++) {
            boolean flag = true;
            int i;
            for (i = 0; i < length - 1; i++) {
                if (!strs[i].substring(0, j).equals(strs[i + 1].substring(0, j))) {
                    flag = false;
                    break;
                }
            }
            if (flag == true && prefix.length() < j) {
                prefix = strs[i].substring(0, j);
            }

        }
        return prefix;
    }

    public static void main (String[] args) {
        String[] strings = {"aaa","aa","aaa"};
        System.out.println(longestCommonPrefix(strings));
    }
}