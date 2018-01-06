package leetcode43;

class Solution {
    public static String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] nums1 = new int[length1];
        int[] nums2 = new int[length2];
        for (int i = length1 - 1, j = 0; i >= 0; i--) {
            nums1[j++] = num1.charAt(i) - 48;
        }
        for (int i = length2 - 1, j = 0; i >= 0; i--) {
            nums2[j++] = num2.charAt(i) - 48;
        }
        int product1 = 0;
        int last1 = 0;
        for (int i = 0; i < length1; i++) {
            int product2 = 0;
            int highNum2 = 0;
            int last2 = 0;
            int j;
            for (j = 0; j < length2; j++) {
                product2 = (nums1[i] * nums2[j] + highNum2) % 10 * (int) Math.pow(10, j)+ last2;
                last2 = product2;
                highNum2 = (nums1[i] * nums2[j] + highNum2) / 10;
            }
            if (highNum2 != 0) {
                product2 = product2 + highNum2 * (int) Math.pow(10, j);
            }
            product1 = product2 * (int) Math.pow(10, i) + last1;
            last1 = product1;
        }
        String string = product1 + "";
        return string;
    }
    public static String multiply1(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pro = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int pro1 = (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
                int index1 = i + j; 
                int index2 = i + j + 1;
                int sum = pro1 + pro[index2] + pro[index1] * 10;
                pro[index1] = sum / 10;
                pro[index2] = sum % 10;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < pro.length; i++) {
            if (stringBuffer.length() == 0 && pro[i] == 0) {
                continue;
            }
            stringBuffer.append(pro[i] + "");
        }
        return stringBuffer.length() == 0 ? "0" : stringBuffer.toString();
    }
    public static void main (String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply1(num1, num2));
    }
}