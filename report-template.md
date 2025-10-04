# Analysis Report (Template)

> Fill this template and export as PDF (max 8 pages).

## 1. Algorithm Overview (1 page)
- Brief description of the algorithm (Boyer–Moore / Kadane).
- Pseudocode.
- When it's appropriate to use.

## 2. Complexity Analysis (2 pages)
- Time complexity: derive Θ, O, Ω for best/worst/average cases.
- Space complexity: auxiliary memory and in-place discussion.
- For Boyer–Moore: explain why it's O(n) time and O(1) space.
- For Kadane: explain single-pass correctness.

## 3. Code Review (2 pages)
- Show snippets of partner's code that are suboptimal.
- Explain why it's inefficient (extra allocations, object boxing, nested loops).
- Suggest concrete fixes (show code diffs).

## 4. Empirical Results (2 pages)
- Include CSV tables and graphs (time vs n).
- Explain measurement methodology (repeats, warm-up, median).
- Compare theoretical slope with measured slope; discuss constant factors.

## 5. Conclusion (1 page)
- Summary of findings.
- Actionable recommendations.
