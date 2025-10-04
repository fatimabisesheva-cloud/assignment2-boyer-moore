package algorithms;

import metrics.PerformanceTracker;

public class KadanesAlgorithm {


    public static class Result {
        public final int maxSum;
        public final int start;
        public final int end;

        public Result(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return maxSum == result.maxSum && start == result.start && end == result.end;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(maxSum, start, end);
        }
    }


    public static Result findMaxSubarray(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length == 0) {
            if (tracker != null) tracker.incrementComparisons(1);
            return new Result(0, -1, -1);
        }

        int max_so_far = arr[0];
        int max_ending_here = arr[0];
        int start_index = 0;
        int end_index = 0;
        int current_start = 0;


        if (tracker != null) {
            tracker.reset();
            tracker.incrementArrayAccesses(1);
            tracker.addMemoryAllocation(4 * 4);
        }

        for (int i = 1; i < arr.length; i++) {

            if (tracker != null) tracker.incrementArrayAccesses(1);


            if (tracker != null) tracker.incrementComparisons(1);

            if (arr[i] > max_ending_here + arr[i]) {
                max_ending_here = arr[i];
                current_start = i;
            } else {
                max_ending_here = max_ending_here + arr[i];
            }


            if (tracker != null) tracker.incrementComparisons(1);

            if (max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
                start_index = current_start;
                end_index = i;
            }
        }

        return new Result(max_so_far, start_index, end_index);
    }
}