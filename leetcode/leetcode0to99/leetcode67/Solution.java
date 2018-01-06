package leetcode67;

class Solution {
    public static String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int count = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
            int x = 0;
            int y = 0;
            if (i >= 0) {
                x = a.charAt(i) - 48;
            }
            if (j >= 0) {
                y = b.charAt(j) - 48;
            }
            int sum = x + y + count;
            if (sum >= 2) {
                count = 1;
                sum = sum - 2;
            }
            else {
                count = 0;
            }
            stringBuffer.append(sum + "");
        }
        if (count == 1) {
            stringBuffer.append("1");
        }
        return stringBuffer.reverse().toString();
    }
    public static void main (String[] args) {
        String a = "1111";
        String b = "1111";
        System.out.println(addBinary(a, b));
    }
}
