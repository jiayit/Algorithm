package leetcode8;

class Solution {
    public static int myAtoi(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        int length = str.length();
        int x = 0;
        int signed = 1;
        boolean flag = false;
        boolean first = false;
        for (int i = 0; i < length; i++) {
            Character c = str.charAt(i);
            if (Character.isWhitespace(c) && flag == false && first == false) {
                continue;
            }
            if (c == '+' && flag == false) {
                flag = true;
                continue;
            }
            if (c == '-' && flag == false) {
                flag = true;
                signed = -1;
                continue;
            }
            if (c > '9' || str.charAt(i) < '0') {
                return x * signed;
            }

            int newX =  x * 10 + c - 48;
            if ((newX - c + 48) / 10 != x || (newX ^ x) < 0) {
                if (signed > 0) {
                    return 0x7fffffff;
                }
                if (signed < 0) {
                    return 0x80000000;
                }
            }
            x = newX;
            first = true;
        }
        x = x * signed;
        return x;
    }

    public static void main(String[] args) {
        String string = "   -123 3 asd ds";
        System.out.println(myAtoi(string));
    }
}