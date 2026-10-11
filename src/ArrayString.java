
import java.util.Arrays;

public class ArrayString {

    // Rotate the array to the right by k positions.
    // Time: O(n), Extra space: O(1)
    public static void rotateRight(int[] a, int k) {
        if (a == null || a.length == 0) {
            return;
        }

        int n = a.length;
        k = ((k % n) + n) % n;

        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
    }

    // Reverse a section of the array in place.
    private static void reverse(int[] a, int left, int right) {
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            left++;
            right--;
        }
    }

    // Check whether two strings are anagrams.
    // Case-sensitive; spaces and punctuation count.
    public static boolean isAnagram(String a, String b) {
        if (a == null || b == null) {
            return a == b;
        }

        if (a.length() != b.length()) {
            return false;
        }

        int[] counts = new int[Character.MAX_VALUE + 1];

        for (int i = 0; i < a.length(); i++) {
            counts[a.charAt(i)]++;
            counts[b.charAt(i)]--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    // Find two zero-based indices whose values add up to target.
    // The input array must be sorted in ascending order.
    // Returns {-1, -1} if no pair exists.
    public static int[] twoSumSorted(int[] a, int target) {
        if (a == null || a.length < 2) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            int sum = a[left] + a[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}

