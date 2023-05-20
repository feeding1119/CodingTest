import sys
from collections import deque
from heapq import heappop,heappush
import math

input = sys.stdin.readline

N,M = map(int,input().split())

s = []

def dfs():
    if len(s) == M:
        print(' '.join(map(str,s)))
        return

    for i in range(1,N+1):
        if len(s) == 0:
            s.append(i)
            dfs()
            s.pop()

        elif i not in s and i > s[-1]:
            s.append(i)
            dfs()
            s.pop()

dfs()

