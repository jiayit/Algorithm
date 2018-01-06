package leetcode22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static List<String> generateParenthesis(int n) {
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = "()";
        }
        List<String> list = new LinkedList<>();
        List<String> res = new LinkedList<>();
        list.add("");
        res.add("");
        for (int i = 0; i < n; i++) {
            List<String> list1 = new LinkedList<>();
            List<String> res1 = new LinkedList<>();
            for (int j = 0; j < 2; j++) {
                for (int m = 0; m < list.size(); m++) {
                    list1.add(list.get(m) + strings[i].charAt(j));
                    res1.add(res.get(m) + strings[i].charAt(1 - j));
                }
            }
            list = list1;
            res = res1;
        }
        List<String> listall = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            listall.add(list.get(i) + res.get(i));
        }
        return listall;
    }
    // recursion
    public static List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    // dynamic programming
    public List<String> generateParenthesis2(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }

            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }
    public static void main (String[] args) {
        int n = 3;
        for (String string : generateParenthesis1(2)) {
            System.out.println(string);
        }
    }
}
