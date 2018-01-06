package leetcode77;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), 1, n, k);
        return list;
    }
    private static void backtrack (List<List<Integer>> list, List<Integer> tempList, int start, int n, int k) {
        if (tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backtrack(list, tempList, i + 1, n, k);
            tempList.remove(tempList.size() - 1);

        }
    }
    public static void main (String[] args) {
        int n = 4;
        int k = 2;
        for (List<Integer> list : combine(n, k)) {
            for (int x : list) {
                System.out.print(x);
            }
            System.out.println();
        }

    }
}
