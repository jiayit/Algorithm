package leetcode89;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // recusion O(nlogn)
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) {
            list.add(0);
            return list;
        }
        LinkedList<String> li = new LinkedList<>();
        li.add("0");
        li.add("1");
        gray(1, n, li);
        for (String string : li) {
            list.add(Integer.parseInt(string, 2));
        }
        return list;
    }
    private static void gray (int i, int n,LinkedList<String> list) {
        LinkedList<String> newList1 = new LinkedList<>(list);
        int len = list.size();
        if (i == n) {
            return;
        }
        list.clear();
        for (int m = 0; m < len; m++) {
            String string = newList1.get(m);
            string =  "0" + string;
            list.add(string);
        }
        for (int m = len - 1; m >= 0; m--) {
            String string = newList1.get(m);
            string = "1" + string;
            list.add(string);
        }
        gray(i + 1, n, list);
    }
    // XOR  O(n)
    public List<Integer> grayCode1(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
    public static void main (String[] args) {
        int n = 0;
        List<Integer> list = grayCode(n);
        for (int x : list) {
            System.out.println(x);
        }
    }
}