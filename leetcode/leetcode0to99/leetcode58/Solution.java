package leetcode58;

class Solution {
    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        }
        int length = strings[strings.length - 1].length();
        return length;
    }
    public static void main (String[] args) {
        String string = " ";
        System.out.println(lengthOfLastWord(string));
    }
}