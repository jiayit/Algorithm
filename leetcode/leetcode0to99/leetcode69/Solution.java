package leetcode69;

class Solution {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int lo = 1;
        int hi = x / 2;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int sqrt = mid * mid;
            long sqrt2 = (mid + 1) * (mid + 1);
            if (sqrt / mid != mid) {
                hi = mid - 1;
                continue;
            }
            if (sqrt == x) {
                return mid;
            }
            else if (sqrt > x && (mid - 1) * (mid - 1) < x) {
                return mid - 1;
            }
            else if (sqrt < x && (sqrt2 > x || sqrt2 < 0)) {
                return mid;
            }
            else if (sqrt < x) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return lo;
    }
    public static void main (String[] args) {
        int x = 2147483647;
        System.out.println(mySqrt(x));
    }
}
