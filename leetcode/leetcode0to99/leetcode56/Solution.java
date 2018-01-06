package leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Interval {
    int start;
    int end;
    public Interval() {
        // TODO Auto-generated constructor stub
        start = 0;
        end = 0;
    }
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        int length = intervals.size();
        int[] start = new int[length];
        int[] end = new int[length];
        for (int i = 0; i < length; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0, j = 0; i < length; i++) {
            if (i == length - 1 || start[i + 1] > end[i]) {
                list.add(new Interval(start[j], end[i]));
                j = i + 1;
            }
        }
        return list;
    }

    //    public List<Interval> merge(List<Interval> intervals) {
    //        List<Interval> list = new ArrayList<>();
    //        for (Interval interval : intervals) {
    //            boolean overlay = false;
    //            Interval newInterval = null;
    //            List<Interval> remove = new ArrayList<>();
    //            for (Interval interval1 : list) {
    //                if (interval.start >= interval1.start && interval.end <= interval1.end) {
    //                    overlay = true;
    //                    break;
    //                }
    //                else if (interval.start <= interval1.end && interval.start >= interval1.start) {
    //                    remove.add(interval1);
    //                    newInterval = new Interval(interval1.start, interval.end);
    //                    overlay = true;
    //
    //                }
    //                else if (interval.end <= interval1.end && interval.end >= interval1.start) {
    //                    remove.add(interval1);
    //                    newInterval = new Interval(interval.start, interval1.end);
    //                    overlay = true;
    //                }
    //                else if (interval.end >= interval1.end && interval.start <= interval1.start) {
    //                    remove.add(interval1);
    //                    newInterval = new Interval(interval.start, interval.end);
    //                    overlay = true;
    //                }
    //            }
    //            if (!overlay) {
    //                list.add(interval);
    //            }
    //            else {
    //                list.removeAll(remove);
    //                if (newInterval != null) {
    //                    list.add(newInterval);
    //                }
    //            }
    //        }
    //        return list;
    //    }
    public static void main (String[] args) {
        List<Interval> list = new ArrayList<>();
        //        list.add(new Interval(1, 3));
        //        list.add(new Interval(2, 6));
        //        list.add(new Interval(8, 10));
        //        list.add(new Interval(15, 18));
        //                list.add(new Interval(2, 3));
        //        list.add(new Interval(2, 3));
        //        list.add(new Interval(4, 5));
        //        list.add(new Interval(6, 7));
        //        list.add(new Interval(8, 9));
        //        list.add(new Interval(1, 10));
        list.add(new Interval(2, 3));
        list.add(new Interval(4, 6));
        list.add(new Interval(5, 7));
        list.add(new Interval(3, 4));
        for (Interval interval : merge(list)) {
            System.out.print(interval.start + "," + interval.end);
            System.out.println();
        }
    }
}
