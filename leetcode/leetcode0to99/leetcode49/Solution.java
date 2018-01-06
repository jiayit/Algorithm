package leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] string1 = strs[i].toCharArray();
            Arrays.sort(string1);
            boolean flag = false;
            for (List<String> list : lists) {
                char[] string2 = list.get(0).toCharArray();
                Arrays.sort(string2);
                if (String.valueOf(string1).equals(String.valueOf(string2))) {
                    flag = true;
                    list.add(strs[i]);
                }
            }
            if (!flag) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
            }
        }
        return lists;
    }
    // use HashMap
    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] string = strs[i].toCharArray();
            Arrays.sort(string);
            String str = String.valueOf(string);
            if (map.containsKey(str)) {
                List<String> list = map.get(str);
                list.add(strs[i]);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(str, list);
            }
        }
        return new ArrayList<>(map.values());
    }
    public static void main (String[] args) {
        String[] strings = {"eat", "tea","ate","tan","nat","bat"};
        List<List<String>> lists = groupAnagrams1(strings);
        for (List<String> list : lists) {
            for (String string : list) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}