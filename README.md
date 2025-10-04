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

## Notes
- Kadane's algorithm (Student B) has been removed from this Student A project.
- The report in `docs/analysis-report-kadane.pdf` analyses Kadane's algorithm (your partner's code) as required by the assignment.
