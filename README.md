# Assignment 2 — Student A (Boyer–Moore Majority Vote)

This repository is prepared for **Student A**. It contains an optimized implementation of **Boyer–Moore Majority Vote** with metrics, tests, and a benchmark runner.

## How to build
```bash
mvn -q -DskipTests package
mvn test
```

## How to run benchmark
Produces `docs/performance-data/results_boyer.csv` with `repeats` rows.

```bash
java -cp target/assignment2-linear-array-1.0-SNAPSHOT.jar cli.BenchmarkRunner --size 10000 --repeats 10
```
## Assignment 2 — Student B (Kadane’s Maximum Subarray)

This project has been updated by Student B with an implementation of Kadane’s Algorithm for finding the maximum subarray sum.

The implementation includes:
* KadanesAlgorithm.java (in `src/main/java/algorithms/`)
* KadanesAlgorithmTest.java (in `src/test/java/algorithms/`)
* Integration with PerformanceTracker.java to measure comparisons and array accesses.

---

## How to run Kadane's Algorithm Tests

To verify the implementation and metrics collection, run the unit tests:

```bash
mvn test -Dtest=KadanesAlgorithmTest
