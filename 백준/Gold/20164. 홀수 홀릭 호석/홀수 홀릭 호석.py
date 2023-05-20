import sys
from collections import deque
from heapq import heappop,heappush
import math

input = sys.stdin.readline

N = input().rstrip()

min_n = math.inf
max_n = 0

def countOdd(n):
    count = 0
    for i in n:
        if int(i)%2 == 1:
            count += 1
    return count

def solve(n,odd_n):
    global min_n,max_n

    if len(n) == 1:
        min_n = min(min_n,odd_n)
        max_n = max(max_n,odd_n)
    elif len(n) == 2:
        temp  = str(int(n[0])+int(n[1]))
        solve(temp,odd_n+countOdd(temp))
    else :
        for i in range(len(n)-2):
            for j in range(i+1,len(n)-1):
                a = n[:i+1]
                b = n[i+1:j+1]
                c = n[j+1:]
                temp = str(int(a) + int(b) + int(c))
                solve(temp,odd_n+countOdd(temp))

solve(N,countOdd(N))
print(min_n, max_n)