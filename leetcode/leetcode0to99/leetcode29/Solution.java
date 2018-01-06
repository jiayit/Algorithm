package leetcode29;

class Solution {
    public static int divide(int dividend, int divisor) {
        int signed = 1;
        if ((dividend ^ divisor) < 0) {
            signed = -1;
        }
        Long dividend1 = Math.abs(new Long(dividend));
        Long divisor1 = Math.abs(new Long(divisor));

        Long result = divide1(dividend1, divisor1);
        int result1 = 0;
        if (result > Integer.MAX_VALUE) {
            result1 = signed == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        else {
            result1 = signed * result.intValue();
        }
        return result1;
    }
    // recursion
    public static Long divide1 (Long dividend, Long divisor) {
        if (dividend < divisor) {
            return (long) 0;
        }
        Long sum = divisor;
        int count = 1;
        while (sum + sum< dividend) {
            sum = sum + sum;
            count = count + count;
        }
        return  count + divide1(dividend - sum, divisor);
    }
    public static void main (String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
    }
}