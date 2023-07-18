package problems;

import java.util.HashSet;

public class Q5 {

	public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Found a duplicate element
            } else {
                seen.add(num); // Add the element to the HashSet
            }
        }

        return false; // No duplicates found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean result = containsDuplicate(nums);
        System.out.println("Output: " + result); 
    }

}
