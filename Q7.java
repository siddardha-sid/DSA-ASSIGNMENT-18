package problems;

public class Q7 {

	 public static int lengthOfLIS(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }

	        int n = nums.length;
	        int[] dp = new int[n];
	        dp[0] = 1;
	        int maxLength = 1;

	        for (int i = 1; i < n; i++) {
	            dp[i] = 1; 
	            for (int j = 0; j < i; j++) {
	                if (nums[i] > nums[j]) {
	                    dp[i] = Math.max(dp[i], dp[j] + 1); 
	                }
	            }
	            maxLength = Math.max(maxLength, dp[i]);
	        }

	        return maxLength;
	    }

	    public static void main(String[] args) {
	        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
	        int result = lengthOfLIS(nums);
	        System.out.println("Output: " + result);
	    }

}
