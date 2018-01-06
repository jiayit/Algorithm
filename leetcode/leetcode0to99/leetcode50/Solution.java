package leetcode50;

class Solution {
    public static double myPow(double x, int n) {
        double result = 1;
        if (n == 0) {
            return 1;
        }
        else if (n > 0) {
            for (int i = 1; i <= n; i++) {
                result = result * x;
            }
        }
        else {
            for (int i = 1; i <= Math.abs(n); i++) {
                result = result / x;
            }
        }
        return result;
    }

    // recursion
    public static double myPow1 (double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE && Math.abs(x) > 1) {
            return 0;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return (n % 2 == 0) ? myPow1(x * x, n / 2) : x * myPow1(x * x, n / 2); 
    }
    // my recursion solution
    public static double myPow2 (double x, int n) {
        if (n % 2 != 0 && x == -1) {
            return - 1;
        }
        if (n == 0 || x == 1 || x == -1) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        int num = 1;
        double x1 = x;
        while (num + num < n) {
            x1 = x1 * x1;
            num = num + num;
            if (x1 == 0) {
                return 0;
            }
        }
        return x1 * myPow2(x, n - num);
    }
    public static void main (String[] args) {
        double x = 2.00000;
        double x1 = -1;
        System.out.println(myPow2(x1, 2147483647));
    }
}