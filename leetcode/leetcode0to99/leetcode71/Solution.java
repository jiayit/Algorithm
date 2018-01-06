package leetcode71;

import java.util.LinkedList;

class Solution {
    public static String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
            else if (!dir.equals(".") && !dir.equals("") && !dir.equals("..")) {
                stack.push(dir);;
            }
        }
        String string = "";
        for (String s : stack) {
            string =  "/" + s + string;
        }
        return string.isEmpty() ? "/" : string;
    }
    public static void main (String[] args) {
        String string = "/abc/bc";
        System.out.println(simplifyPath(string));
    }
}