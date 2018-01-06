package leetcode95;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public static List<TreeNode> generateTrees(int n) {          
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }
    private static List<TreeNode> generateTrees(int start, int end) {
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
    public static void main (String[] args) {
        List<TreeNode> list = generateTrees(3);
    }
}