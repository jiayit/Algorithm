package leetcode13;

class Solution {
    public static int romanToInt(String s) {
        int length = s.length();
        int x = 0;
        Character last = ' ';
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);

            if (c == 'I') {
                x = x + 1;
            }
            else if (c == 'V' && last == 'I') {
                x = x + 3;
            }
            else if (c == 'V'){
                x = x + 5;
            }
            else if (c == 'X' && last == 'I') {
                x = x + 8;
            }
            else if (c == 'X') {
                x = x + 10;
            }
            else if (c == 'L' && last == 'X') {
                x = x + 30;
            }
            else if (c == 'L') {
                x = x + 50;
            }
            else if (c == 'C' && last == 'X') {
                x = x + 80;
            }
            else if (c == 'C'){
                x = x + 100;
            }
            else if (c == 'D' && last == 'C') {
                x = x + 300;
            }
            else if (c == 'D') {
                x = x + 500;
            }
            else if (c == 'M' && last == 'C') {
                x = x + 800;
            }
            else if (c == 'M') {
                x = x + 1000;
            }

            last = c;
        }
        return x;
    }
    public static void main (String[] args) {
        String string = "MMMXLV";
        System.out.println(romanToInt(string));
    }
}