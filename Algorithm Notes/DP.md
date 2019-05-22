1D, 2 sets of problems, use 1D dp array
1D w/ multiple states, use dp[i][0], dp[i][1], dp[i][2] i is the problem size

1.1
input O(n)
dp solution of a subproblem
dp[i] only depends on const number of subproblems
TC O(n)
SC O(n) -> O(1)
Template:
dp = [0] * n
for i = 1 to n:
    dp[i] = f(dp[i - 1], dp[i- 2], ...)
return dp[n]

1.2
input O(n)
dp[i] depends on all smaller problems
TC O(n^2)
SC O(n)
Template:
dp = [0] * n
for i = 1 to n:
    for j = 1 to i - 1:
        dp[i] = max/min(dp[1], f(dp[j]))
return dp[n]

1.3
input O(m) + O(n)
dp[i][j] depends on const smaller problems
TC O(mn)
SC O(mn)
Template:
dp = new int[m][n]
for i = 1 to n:
    for j = 1 to m:
        dp[i][j] = f(dp[i - 1][j - 1], dp[i- 1][j], dp[i][j - 1])
return dp[m][n]

1.4
input O(n)
dp[i][j] subarray of input, each subproblem depends on O(n) smaller problem
TC O(n^3)
SC O(n^2)
Template:
dp = new int[m][n]
for l = 1 to n:
    for i = 1 to n;
        j = i + l - 1
        for k = i to j
            dp[i][j] = max(dp[i][j], f(dp[i][k], dp[k][j]))
return dp[1][n]

2.1
input O(mn)
dp[i][j] each subproblem depends on O(1) subproblems
TC O(mn)
SC O(mn)
Template:
dp = new int[m][n]
for i = 1 to n:
    for j = 1 to m:
        dp[i][j] = f(dp[i - 1][j], dp[i][j - 1])
return dp[m][n] / max(dp[n])

2.2
input O(mn)
dp[k][i][j] earch subproblem depends on O(1) subproblems
TC O(kmn)
SC O(kmn)
Template:
dp = new int[k][m][n]
for k = 1 to k:
    for i = 1 to n:
        for j = 1 to m:
            dp[k][i][j] = f(dp[k - 1][i + di][j +dj])
return dp[k][m][n] / g(dp[k])