package leetcode200to299.leetcode295;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int numOfElements;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }

        }
                );
        minHeap = new PriorityQueue<Integer>();
        numOfElements = 0;
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
            int temp1 = maxHeap.poll();
            minHeap.add(temp1);

        }
        if (maxHeap.size() + 1 < minHeap.size() ) {
            int temp1 = minHeap.poll();
            maxHeap.add(temp1);
        }
        numOfElements++;
    }

    public double findMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return Double.MIN_VALUE;
        }
        else if (maxHeap.isEmpty()) {
            return minHeap.peek();
        }
        else if (minHeap.isEmpty()) {
            return maxHeap.peek();
        }
        else if (numOfElements % 2 == 0) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class Solution {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(4);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
