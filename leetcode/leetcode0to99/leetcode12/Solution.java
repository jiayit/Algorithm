package leetcode12;

class Solution {
    public static String intToRoman(int num) {
        String string = "";
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                string += strings[i];
                num -= values[i];
            }
        }
        return string;
    }
    public static void main (String[] args) {
        int x = 1666;
        System.out.println(intToRoman(x));
    }
}
