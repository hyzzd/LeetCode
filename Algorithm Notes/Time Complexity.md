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