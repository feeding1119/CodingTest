import sys
from collections import deque
from heapq import heappop,heappush
import math

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n = int(input())

    score = []
    for _ in range(2):
        score.append(list(map(int,input().split())))

    dp = [[0]*(n+1) for _ in range(2)]

    dp[0][1] = score[0][0]
    dp[1][1] = score[1][0]

    for i in range(2,n+1):
        dp[0][i] = score[0][i-1] + max(dp[1][i-1],dp[1][i-2])
        dp[1][i] = score[1][i-1] + max(dp[0][i-1],dp[0][i-2])

    print(max(dp[0][n],dp[1][n]))