import sys
from collections import deque
from heapq import heappop,heappush
import math

input = sys.stdin.readline

C,N = map(int,input().split())

city = [list(map(int,input().split())) for _ in range(N)]

dp = [math.inf]*(C+100)

dp[0] = 0

for cost,people in city:
    for i in range(people,C+100):
        dp[i] = min(dp[i-people]+cost,dp[i])

print(min(dp[C:]))