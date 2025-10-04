package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import metrics.PerformanceTracker;
import algorithms.KadanesAlgorithm.Result;

public class KadanesAlgorithmTest {

    private final PerformanceTracker tracker = new PerformanceTracker();

    @Test
    void testBasicCase() {
        int[] arr = {4, -1, 2, 1, -5};
        Result expected = new Result(6, 0, 3);
        assertEquals(expected, KadanesAlgorithm.findMaxSubarray(arr, tracker),
                "Basic case test failed.");
    }

    @Test
    void testNegativeNumbers() {
        int[] arr = {-2, -5, -1, -8, -3};
        Result expected = new Result(-1, 2, 2);
        assertEquals(expected, KadanesAlgorithm.findMaxSubarray(arr, tracker),
                "Test: all negative numbers.");
    }

    @Test
    void testAllPositive() {
        int[] arr = {1, 2, 3};
        Result expected = new Result(6, 0, 2);
        assertEquals(expected, KadanesAlgorithm.findMaxSubarray(arr, tracker),
                "Test: all positive numbers.");
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        Result expected = new Result(0, -1, -1);
        assertEquals(expected, KadanesAlgorithm.findMaxSubarray(arr, tracker),
                "Test: empty array.");
    }

    @Test
    void testSingleElement() {
        int[] arr = {10};
        Result expected = new Result(10, 0, 0);
        assertEquals(expected, KadanesAlgorithm.findMaxSubarray(arr, tracker),
                "Test: single element.");
    }

    @Test
    void testMetricsCollection() {
        int N = 10;
        int[] arr = {1, 2, 3, 4, 5, -1, -2, 3, 4, 5};
        tracker.reset();
        KadanesAlgorithm.findMaxSubarray(arr, tracker);

        // Expected metrics: minimum 18 comparisons and 10 array accesses.
        assertTrue(tracker.getComparisons() >= 18, "Comparison metrics must be recorded.");
    }
}