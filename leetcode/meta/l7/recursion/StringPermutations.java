package leetcode.meta.l7.recursion;

import java.util.HashSet;
import java.util.Set;

// GoOver Computing all permutations of a string.
public class StringPermutations {
    public static void generatePermutations(String str, int left, int right, Set<String> result) {
        if (left == right) {
            result.add(str); // Store unique permutations
            return;
        }

        for (int i = left; i <= right; i++) {
            str = swap(str, left, i);
            generatePermutations(str, left + 1, right, result);
            str = swap(str, left, i); // Backtrack to restore original state
        }
    }

    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    public static void main(String[] args) {
        String input = "ABC";
        Set<String> result = new HashSet<>();
        generatePermutations(input, 0, input.length() - 1, result);

        System.out.println("Permutations: " + result);
    }
}
