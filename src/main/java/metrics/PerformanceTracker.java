package metrics;

public class PerformanceTracker {


    public long comparisons = 0;
    public long arrayAccesses = 0;
    public long swaps = 0;
    public long allocations = 0;


    public long startTimeNs = 0;
    public long endTimeNs = 0;


    public void reset() {
        comparisons = 0;
        arrayAccesses = 0;
        swaps = 0;
        allocations = 0;
        startTimeNs = 0;
        endTimeNs = 0;
    }

    public void incrementComparisons(long count) {
        this.comparisons += count;
    }

    public void incrementArrayAccesses(long count) {
        this.arrayAccesses += count;
    }

    public void addMemoryAllocation(long bytes) {
        this.allocations += bytes;
    }


    public long getComparisons() {
        return this.comparisons;
    }

    // Методы таймера и вывода (были в вашем коде)
    public void startTimer(){ startTimeNs = System.nanoTime(); }
    public void stopTimer(){ endTimeNs = System.nanoTime(); }
    public long elapsedNs(){ return endTimeNs - startTimeNs; }

    public String toCsvRow(String label, int n) {
        return String.format("%s,%d,%d,%d,%d,%d,%d",
                label, n, elapsedNs(), comparisons, arrayAccesses, swaps, allocations);
    }

    public static String csvHeader() {
        return "label,n,elapsed_ns,comparisons,array_accesses,swaps,allocations";
    }
}