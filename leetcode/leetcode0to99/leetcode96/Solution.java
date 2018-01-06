package leetcode96;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    // recusive solution(Time limited)
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        List<TreeNode> list = generateTrees(1, n);
        return list.size();
    }
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start == end) {
            list.add(new TreeNode(start));
        }
        else if (start > end) {
            list.add(null);
            return list;
        }
        else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> list1 = generateTrees(start, i - 1);
                List<TreeNode> list2 = generateTrees(i + 1, end);
                for (TreeNode left : list1) {
                    for (TreeNode right : list2) {
                        TreeNode middle = new TreeNode(i);
                        middle.left = left;
                        middle.right = right;
                        list.add(middle);
                    }
                }

            }
        }
        return list;
    }
    //dp 
    public static int numTrees1(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 0; j < i; j++) {
                G[i] = G[i] + G[j] * G[i - j - 1];
            }
        }
        return G[n];
    }
    public static void main (String[] args) {
        System.out.println(numTrees1(3));
    }
}
