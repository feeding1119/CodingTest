import sys
from collections import deque
from heapq import heappop,heappush

input = sys.stdin.readline

N,M= map(int,input().split())
train = [[0]*21 for _ in range(N+1)]
started = []
count = 0

for i in range(M):
    command = list(map(int,input().split()))
    if command[0] == 1:
        train[command[1]][command[2]] = 1
    elif command[0] == 2:
        train[command[1]][command[2]] = 0
    elif command[0] == 3:
        for j in range(20,1,-1):
            if train[command[1]][j-1] == 1:
                train[command[1]][j] = 1
            else :
                train[command[1]][j] = 0
        train[command[1]][1] = 0
    elif command[0] == 4:
        for k in range(1,20):
            if train[command[1]][k+1] == 1:
                train[command[1]][k] = 1
            else :
                train[command[1]][k] = 0
        train[command[1]][20] = 0

for i in range(1,N+1):
    if train[i] not in started:
        count += 1
        started.append(train[i])

print(count)