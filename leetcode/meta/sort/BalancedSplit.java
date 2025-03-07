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

