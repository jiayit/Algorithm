package quicksort;

class QuickSort {
    public void sort (int[] a) {
        sort(a, 0, a.length - 1);
    }
    public void sort (int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    public int  partition (int[]a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (i < j) {
            while (a[++i] < a[lo]) {
                if (i == hi) break;
            }
            while (a[--j] > a[lo]) {
                if (j == lo) break;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, lo, j);
        return j;
    }
    private void swap (int[]a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

public class Solution {
    public static void main (String[] args) {
        int[] a = {6,1,1,2,6,3,4,7,7};
        int[] b = {4,2,1,6,3,5};
        QuickSort sort = new QuickSort();
        sort.sort(b);
        for (int x : b) {
            System.out.print(x);
        }
    }
}

