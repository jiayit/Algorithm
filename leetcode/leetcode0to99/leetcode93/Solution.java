package leetcode93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() == 4 || s.length() == 12) {
            String str = "";
            int index = s.length() / 4;
            for (int i = 0; i < 4; i++) {
                str = str + s.substring(i * index, i * index + index); 
                if (i != 3) {
                    str = str + ".";
                }
            }
            list.add(str);
        }
        else {
            dfs(list, new ArrayList<>(), s, 0, 0);
        }
        return list;
    }
    private static void dfs(List<String> list, List<String> tempList, String s, int index, int count) {
        int n = s.length();
        if (count == 4 && index == n) {
            String str = "";
            for (int i = 0; i < tempList.size(); i++) {
                str = str + tempList.get(i); 
                if (i != tempList.size() - 1) {
                    str = str + ".";
                }
            }
            if (!list.contains(str)) {
                list.add(str);
            }

        }
        else if (count > 4 && index < n) {
            return;
        }
        else {
            for (int i = 1; i <= 3; i++) {
                if (index + i <= n) {
                    int x = Integer.parseInt(s.substring(index, index + i));
                    if (s.substring(index, index + 1).equals("0") && i > 1) {
                        continue;
                    }
                    else if (x <= 255) {
                        tempList.add(x + "");
                        dfs(list, tempList, s, index + i, ++count);
                        count--;
                        tempList.remove(tempList.size() - 1);

                    }
                }
            }
        }
    }
    public static void main (String[] args) {
        String string = "1252524255";
        String string1 = "010010";
        List<String> list = restoreIpAddresses(string1);
        for (String str : list) {
            System.out.println(str);
        }

    }
}
