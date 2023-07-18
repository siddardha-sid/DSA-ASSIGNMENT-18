package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {

	public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

       
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            
            if (nextInterval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
              
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

      
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mergeIntervals(intervals);
        System.out.println("Output: " + Arrays.deepToString(result));
        // Output: [[1, 6], [8, 10], [15, 18]]
    }

}
