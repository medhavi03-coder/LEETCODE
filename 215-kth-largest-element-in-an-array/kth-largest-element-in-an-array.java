import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            // Keep only k elements in the heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();
    }
}
