import sys
from collections import deque
from heapq import heappop,heappush

input = sys.stdin.readline

bracket = input().rstrip()

stack = []
temp = 1
sum = 0

for i in range(len(bracket)):

    if bracket[i] == '(' :
        stack.append(bracket[i])
        temp *= 2

    elif bracket[i] == '[':
        stack.append(bracket[i])
        temp *= 3

    elif bracket[i] == ')':
        if len(stack) == 0 or stack[-1] == '[':
            sum = 0
            break
        if bracket[i-1] == '(':
            sum += temp
        stack.pop()
        temp //= 2

    elif bracket[i] == ']':
        if len(stack) == 0 or stack[-1] == '(':
            sum = 0
            break
        if bracket[i-1] == '[':
            sum += temp
        stack.pop()
        temp //= 3

if stack:
    print(0)
else:
    print(sum)
