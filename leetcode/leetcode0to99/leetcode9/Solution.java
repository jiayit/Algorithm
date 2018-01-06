package leetcode9;

class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int result = 0;
        int init = x;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return false;
            }

            result = newResult;
            x = x / 10;
        }
        if (result == init) {
            return true;
        }
        return false;
    }
    public boolean isPalindrome1(int x) {
        if (x<0 || (x!=0 && x % 10 ==0)) return false;
        int rev = 0;
        while (x > rev){
            rev = rev*10 + x % 10 ;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
    public static void main(String[] args) {
        int x = 1123456789;
        System.out.println(isPalindrome(x));
    }
}