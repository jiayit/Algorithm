package leetcode66;

class Solution {
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int[] digits2 = new int[length + 1];
        int i;
        for (i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                break;
            }
            else {
                digits[i] = 0;
            }
        }
        if (i < 0 && digits[0] == 0) {
            for (int j = 0; j < length + 1; j++) {
                if (j == 0) {
                    digits2[j] = 1;
                }
                else {
                    digits2[j] = 0;
                }
            }
            return digits2;
        }
        return digits;
    }
    public static void main (String[] args) {
        int[] digits = {9};
        int[] digits2 = plusOne(digits);
        for (int digit : digits2) {
            System.out.print(digit);
        }
    }
}
