import sys
from collections import deque
from heapq import heappop,heappush

input = sys.stdin.readline

N = int(input())

tower = list(map(int,input().split()))
stack = []
answer = []

for i in range(N):
    while stack:
        if stack[-1][1] > tower[i]:
            answer.append(stack[-1][0]+1)
            break
        else:
            stack.pop()
    if not stack:
        answer.append(0)
    stack.append([i,tower[i]])

for i in range(N):
    print(answer[i],end=" ")

