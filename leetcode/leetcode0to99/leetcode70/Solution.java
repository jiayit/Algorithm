package leetcode70;

class Solution {
    public static int climbStairs(int n) {
        int steps = 0;
        int num = n / 2;
        for (int i = num; i >= 0; i--) {
            int remain = n - i * 2;
            long temp1 = 1;
            long temp2 = 1;
            int base = Math.min(remain, i);
            for (int j = 0; j < base; j++) {
                temp1 = temp1 * (i + remain - j);
                temp2 = temp2 * (j + 1);
                if (temp1 % temp2 == 0) {
                    temp1 = temp1 / temp2;
                    temp2 = 1;
                }
            }
            steps = (int) (steps + temp1 / temp2);
        }
        return steps;
    }
    public static void main (String[] args) {
        int n = 44;
        System.out.println(climbStairs(n));
    }
}