package leetcode.meta.l7.sorting;
/*
Counting Triangles
Given a list of N triangles with integer side lengths, determine how many different triangles there are. Two triangles are considered to be the same if they can both be placed on the plane such that their vertices occupy exactly the same three points.
Signature
int countDistinctTriangles(ArrayList<Sides> arr)
or
int countDistinctTrianges(int[][] arr)
Input
In some languages, arr is an Nx3 array where arr[i] is a length-3 array that contains the side lengths of the ith triangle. In other languages, arr is a list of structs/objects that each represent a single triangle with side lengths a, b, and c.
It's guaranteed that all triplets of side lengths represent real triangles.
All side lengths are in the range [1, 1,000,000,000]
1 <= N <= 1,000,000
Output
Return the number of distinct triangles in the list.
Example 1
arr = [[2, 2, 3], [3, 2, 2], [2, 5, 6]]
output = 2
The first two triangles are the same, so there are only 2 distinct triangles.
Example 2
arr = [[8, 4, 6], [100, 101, 102], [84, 93, 173]]
output = 3
All of these triangles are distinct.
Example 3
arr = [[5, 8, 9], [5, 9, 8], [9, 5, 8], [9, 8, 5], [8, 9, 5], [8, 5, 9]]
output = 1
All of these triangles are the same.
 */
import java.util.*;
// Add any extra import statements you may need here


class CountingTriangles {

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    // Add any helper functions you may need here

    public static void main(String[] args) {
        new CountingTriangles().run();
    }

    int countDistinctTriangles(ArrayList<Sides> arr) {
        Set<Sides> uniqueSides = new HashSet<>();
        arr.stream().forEach(uniqueSides::add);
        return uniqueSides.size();
    }

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        int expected_1 = 3;
        int output_1 = countDistinctTriangles(arr_1);
        check(expected_1, output_1);

        ArrayList<Sides> arr_2 = new ArrayList<>();
        arr_2.add(new Sides(3, 4, 5));
        arr_2.add(new Sides(8, 8, 9));
        arr_2.add(new Sides(7, 7, 7));
        int expected_2 = 3;
        int output_2 = countDistinctTriangles(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    class Sides{
        int a;
        int b;
        int c;

        private int max;
        private int min;
        private int mid;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;

            max = a > b ? (a > c ? a : c) : (b > c ? b : c);
            min = a < b ? (a < c ? a : c) : (b < c ? b : c);
            mid = a + b + c - max - min;
        }

        public int hashCode() {
            return 7 * min + 49 * mid + 384 * max;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Sides)) {
                return false;
            }

            Sides that = (Sides) obj;

            return this.max == that.max &&
                    this.min == that.min &&
                    this.mid == that.mid;
        }
    }
}
