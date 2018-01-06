package leetcode7;

class Solution {
    public static int reverse(int x) {
        if ((x & 0x7fffffff) == 0) {
            return 0;
        }
        int x1 = x;;
        int signed = x & 0x80000000;
        if (signed != 0) {
            x1= 0x7fffffff + 1 - x & 0x7fffffff;
        }
        StringBuffer string = new StringBuffer(x1 + "");
        String string2 = string.reverse().toString();
        if (Long.valueOf(string2) > 0x7fffffff) {
            return 0;
        }
        int x2 = Integer.valueOf(string2);
        if (signed != 0) {
            x2= 0x7fffffff - (x2 - 1);
            x2 = x2 | 0x80000000;
        }
        return x2;

    }
    public static int reverse1(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse1(x));
    }
}