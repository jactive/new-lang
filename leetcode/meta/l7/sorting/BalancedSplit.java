
package leetcode.meta.l7.sorting;
/**

Balanced Split
Given an array of integers (which may include repeated integers), determine if there's a way to split the array into two subsequences A and B such that the sum of the integers in both arrays is the same, and all of the integers in A are strictly smaller than all of the integers in B.
Note: Strictly smaller denotes that every integer in A must be less than, and not equal to, every integer in B.
Signature
bool balancedSplitExists(int[] arr)
Input
All integers in array are in the range [0, 1,000,000,000].
Output
Return true if such a split is possible, and false otherwise.
Example 1
arr = [1, 5, 7, 1]
output = true
We can split the array into A = [1, 1, 5] and B = [7].
Example 2
arr = [12, 7, 6, 7, 6]
output = false
We can't split the array into A = [6, 6, 7] and B = [7, 12] since this doesn't satisfy the requirement that all integers in A are smaller than all integers in B.

*/
import java.util.*;

public class BalancedSplit {
    public static boolean balancedSplitExists(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // If total sum is odd, it cannot be evenly split
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int leftSum = 0;

        // Use TreeMap to store frequency and keep numbers sorted
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Iterate over the sorted keys
        for (int key : freqMap.keySet()) {
            int count = freqMap.get(key);
            for (int i = 0; i < count; i++) { // Process each occurrence
                leftSum += key;

                if (leftSum == target) {
                    // Ensure strictly smaller condition: check next larger key
                    return freqMap.higherKey(key) != null;
                }

                if (leftSum > target) {
                    return false;
                }
            }
        }

        return false;
    }

    // Example test cases
    public static void main(String[] args) {
        System.out.println(balancedSplitExists(new int[]{1, 5, 7, 1}));  // true
        System.out.println(balancedSplitExists(new int[]{12, 7, 6, 7, 6}));  // false
        System.out.println(balancedSplitExists(new int[]{3, 6, 3, 4, 4}));  // false
        System.out.println(balancedSplitExists(new int[]{1, 2, 3, 4, 10}));  // true
    }
}

