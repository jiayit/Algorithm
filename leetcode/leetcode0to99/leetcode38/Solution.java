package leetcode38;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String countAndSay(int n) {
        List<String> list = new ArrayList<String>();
        countAndSay(list, "1", n, 1);
        return list.get(0);
    }
    public static void countAndSay(List<String> list, String string1, int n, int num) {
        if (num == n) {
            list.add(string1);
            return;
        }
        String string2 = "";
        char[] chars = string1.toCharArray();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1 ||chars[i] != chars[i + 1]) {
                string2 = string2 + count + chars[i];
                count = 1;
            }
            else {
                count++;
                continue;
            }
        }
        countAndSay(list, string2, n, ++num);
    }
    //    public static String countAndSay1(int n) {
    //        String string = "";
    //        for (int m = 0; m < n; m++) {
    //
    //        }
    //    }

    public static void main (String[] args) {
        int n = 3;
        System.out.println(countAndSay(8));
    }
}