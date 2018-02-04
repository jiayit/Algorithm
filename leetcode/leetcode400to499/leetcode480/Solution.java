package leetcode400to499.leetcode480;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            return o2.compareTo(o1);
        }
    }
            );
    int numOfElements;
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] medians = new double[len - k + 1];
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        medians[0] = findMedian();
        int j = 1;
        for (int i = k; i < len; i++) {
            addNum(nums[i]);
            removeNum(nums[i - k]);
            medians[j++] = findMedian();
        }
        return medians;
    }
    public void addNum(int num) {
        double median = findMedian();
        if (num > median) {
            minHeap.add(num);
        }
        else {
            maxHeap.add(num);
        }
        if (minHeap.size() + 1 < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (maxHeap.size() + 1 < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        } 
        numOfElements++;
    }
    public void removeNum(int num) {
        if (minHeap.contains(num)) {
            minHeap.remove(num);
        }
        else {
            maxHeap.remove(num);
        }
        if (minHeap.size() + 1 < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (maxHeap.size() + 1 < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        } 
        numOfElements--;
    }
    public double findMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return Double.MIN_VALUE;
        }
        else if (minHeap.isEmpty()) {
            return maxHeap.peek();
        }
        else if (maxHeap.isEmpty()) {
            return minHeap.peek();
        }
        else if (numOfElements % 2 == 0) {
            return (double) minHeap.peek() / 2 + (double) maxHeap.peek() / 2;
        }
        else {
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }
}
public class Solution {
    public static void main (String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums1 = {2147483647,2147483647};
        MedianFinder medianFinder = new MedianFinder();
        double[] medians = medianFinder.medianSlidingWindow(nums1, 2);
        for (double median : medians) {
            System.out.println(median);
        }
    }
}
