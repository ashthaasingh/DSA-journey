package Arrays.Medium;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // 1. Sort by starting value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // 2. Start with the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // 3. Overlap
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }

            // 4. No overlap
            else {
                result.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}