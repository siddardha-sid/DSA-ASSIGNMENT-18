package problems;

import java.util.Arrays;

public class Q4 {

	public class MaximumGapFinder {
	    public static int maximumGap(int[] nums) {
	        int n = nums.length;
	        if (n < 2) {
	            return 0;
	        }

	        int minNum = nums[0];
	        int maxNum = nums[0];
	        for (int num : nums) {
	            minNum = Math.min(minNum, num);
	            maxNum = Math.max(maxNum, num);
	        }

	        int bucketSize = Math.max(1, (maxNum - minNum) / (n - 1));
	        int bucketCount = (maxNum - minNum) / bucketSize + 1;

	        int[] minBucket = new int[bucketCount];
	        int[] maxBucket = new int[bucketCount];
	        Arrays.fill(minBucket, Integer.MAX_VALUE);
	        Arrays.fill(maxBucket, Integer.MIN_VALUE);

	        for (int num : nums) {
	            int index = (num - minNum) / bucketSize;
	            minBucket[index] = Math.min(minBucket[index], num);
	            maxBucket[index] = Math.max(maxBucket[index], num);
	        }

	        int maxGap = 0;
	        int prevMax = minNum;
	        for (int i = 0; i < bucketCount; i++) {
	            if (minBucket[i] != Integer.MAX_VALUE) {
	                maxGap = Math.max(maxGap, minBucket[i] - prevMax);
	                prevMax = maxBucket[i];
	            }
	        }

	        return maxGap;
	    }

	    public static void main(String[] args) {
	        int[] nums = {3, 6, 9, 1};
	        int result = maximumGap(nums);
	        System.out.println("Output: " + result); // Output: 3
	    }}}
	
