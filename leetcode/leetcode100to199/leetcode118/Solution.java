package leetcode100to199.leetcode118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            if (i == 0) {
                tempList.add(1);
            }
            else {
                List<Integer> last = list.get(i - 1);
                for (int j = 0; j <= i;j++) {
                    if (j == 0 || j == i) {
                        tempList.add(1);
                    }
                    else {
                        tempList.add(last.get(j - 1) + last.get(j));
                    }
                }
            }
            list.add(tempList);
        }
        return list;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        generate(3);
    }

}
