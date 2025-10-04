# Code Review — Boyer–Moore & Kadane (Detailed)

## Summary
This review inspects the implementations in `algorithms/` and focuses on correctness, performance, and clarity.

## Issues found
1. **Autoboxing (Integer) in BoyerMooreMajority**: Using `Integer candidate` results in unnecessary boxing/unboxing; use `int candidate` plus a flag variable.
2. **Double-counted comparisons**: Some branches increment `pt.comparisons` multiple times making comparison counts inconsistent.
3. **Array access accounting**: `pt.arrayAccesses` should reflect actual reads/writes; current code sometimes overcounts (e.g., counting the same access multiple times).
4. **Benchmark robustness**: Single-run per n is insufficient. Add warm-ups and repeats, and record median times.

## Suggested code changes (snippets)
- Replace boxed candidate with primitive and flag:
```java
int candidate = 0;
int count = 0;
boolean hasCandidate = false;
for (int v : arr) {
    if (!hasCandidate) { candidate = v; count = 1; hasCandidate = true; }
    else { if (candidate == v) count++; else count--; if (count==0) hasCandidate=false; }
}
```
- Benchmark changes: run `repeats = 10` and compute median elapsed time across repeats; write all repeats to CSV for reproducibility.

## Suggested tests to add
- Very large arrays where majority exists at start/middle/end.
- For Kadane, test arrays with large magnitude integers to verify no overflow (consider using long if necessary).
- Property-based test: random arrays, compare Kadane's result with brute-force O(n^2) on small n.

## Estimated impact
Applying these changes should reduce allocations and improve timing constants by ~10-30% depending on JVM and data locality.
