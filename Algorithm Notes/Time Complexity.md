CPU: 2GHz ~ 2G ops ~ 2*10^9 for single core
Overhead: memory access/branching
Large const factor: set O(1) can be order slower than O(logn)
Rough estimation: 10^6 - 10^7 ops/sec

Suppose run time is 1 sec, then input size:
10 - n! 2^n
50 - n^4
100 - n^3
1000 - n^2 (dp^2)
10^6 - nlogn (sorting, divide & conquer, heap)
10^7 - n (dp^1, greedy)
10^9 - n^0.5 logn (binary search)
... - 1 (math, bit manipulation)


Master Theorem:
Quick sort: O(nlogn), O(n^2) / O(logn), O(n) - T(n) = 2 * T(n / 2) + O(n), T(n) = T(n - 1) + O(1)
Merge sort: O(nlogn) / O(logn + n) - T(n) = 2 * T(n / 2) + O(n)

Binary search: O(logn) / O(logn) - T(n) = T(n / 2) + O(1)
Inorder: O(n) / O(n) - T(n) = 2 * T(n / 2) + O(1)

Combination: O(2^n) / O(n) - T(n) = T(n - 1) + T(n - 2) + ... + T(1)
Permutation: O(n!) / O(n) - T(n) = n * T(n - 1)

DP with memo:
Time: number of subproblems * exclusive time to solve each subproblem
Space: max depth of call stack * space used by earch subproblem