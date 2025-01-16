package com.oa.company.meta;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public int kthSmallest(List<int[]> lists, int k) {
        var minHeap = new PriorityQueue<Node>((a, b) -> a.value - b.value);

        // put the first element of each sorted array in the min heap
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).length > 0) {
                minHeap.add(new Node(i, 0, lists.get(i)[0]));
            }
        }

        int count = 0; // keep track of how many elements we have processed
        int result = 0; // the smallest element in the min heap

        // take the smallest (top) element form the min heap and if the running count is
        // equal to k return the number
        while (!minHeap.isEmpty()) {
            var currentNode = minHeap.poll();
            result = currentNode.value;
            count++;
            if (count == k) {
                // if we have found the kth smallest element, return it
                break;
            }

            int nextIndex = currentNode.elementIndex + 1;
            int arrayIndex = currentNode.arrayIndex;

            if (nextIndex < lists.get(arrayIndex).length) {
                // if the array of the top element has more elements, add the next element to
                // the heap
                minHeap.add(new Node(arrayIndex, nextIndex, lists.get(arrayIndex)[nextIndex]));
            }
        }

        return result;
    }

    /*
     * @param arrayIndex: the index of the array
     * 
     * @param elementIndex: the index of the element in the array
     * 
     * @param value: the value of the element
     */
    record Node(int arrayIndex, int elementIndex, int value) {
    };

    public static void main(String[] args) {
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        List<int[]> lists = List.of(new int[] { 2, 6, 8 }, new int[] { 3, 6, 7 }, new int[] { 1, 3, 4 });
        int k = 5;
        System.out.println(kthSmallestElement.kthSmallest(lists, k));
    }
}
