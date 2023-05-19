import sys
from collections import deque
from heapq import heappop,heappush

input = sys.stdin.readline

K = int(input())

for i in range(K):
    N,M= map(int,input().split())
    wait = deque(list(map(int,input().split())))
    count = 0

    while wait:
        if wait[0] == max(wait):
            count += 1
            wait.popleft()
            if M==0 :
                print(count)
                break
            M -= 1
        else :
            wait.append(wait.popleft())
            if M > 0 :
                M -= 1
            else :
                M = len(wait)-1

