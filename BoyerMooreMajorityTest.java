package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoyerMooreMajorityTest {
    @Test
    public void testEmpty() {
        PerformanceTracker pt = new PerformanceTracker();
        int[] arr = new int[0];
        BoyerMooreMajority.Result r = BoyerMooreMajority.findMajority(arr, pt);
        assertFalse(r.exists);
    }

    @Test
    public void testSingleElement() {
        PerformanceTracker pt = new PerformanceTracker();
        int[] arr = {5};
        BoyerMooreMajority.Result r = BoyerMooreMajority.findMajority(arr, pt);
        assertTrue(r.exists);
        assertEquals(5, r.value);
    }

    @Test
    public void testNoMajority() {
        int[] arr = {1,2,3,4,5,6};
        BoyerMooreMajority.Result r = BoyerMooreMajority.findMajority(arr, new PerformanceTracker());
        assertFalse(r.exists);
    }

    @Test
    public void testMajorityPresent() {
        int[] arr = {2,2,1,2,3,2,2};
        BoyerMooreMajority.Result r = BoyerMooreMajority.findMajority(arr, new PerformanceTracker());
        assertTrue(r.exists);
        assertEquals(2, r.value);
    }
}
