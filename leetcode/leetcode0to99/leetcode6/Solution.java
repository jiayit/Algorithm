package leetcode6;

class Solution {
    public static String convert(String s, int numRows) {
        int length = s.length();
        if (length / numRows == 0 || numRows == 1) {
            return s;
        }
        StringBuffer string = new StringBuffer();
        int c = (length / (2 * numRows- 2)) * (numRows - 1);
        if (length % (2 * numRows- 2) >= 1 && length % (2 * numRows- 2) < numRows ) {
            c = c + 1;
        }
        if (length % (2 * numRows- 2) / numRows >= 1) {
            c = c + 1 + length % (2 * numRows- 2) % numRows;
        }
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < c; col++) {

                if (col % (numRows -1) == 0 && (2 * col + row) < length) {
                    string.append(s.charAt(2 * col + row));
                    continue;
                }
                if (row + col % (numRows - 1) + 1 == numRows && (2 * col + row) < length) {
                    string.append(s.charAt(2 * col + row));
                    continue;
                }
                //                string.append(" ");
            }
            //            string.append("\n");

        }
        return string.toString();
    }

    public static void main(String[] args) {
        String string = "PAYPALISHIRING";
        String string1 = "ABCDEF";
        System.out.println(convert(string, 10));
    }
}