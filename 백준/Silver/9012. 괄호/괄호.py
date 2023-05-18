import sys
from collections import deque

input = sys.stdin.readline

N= int(input())

for i in range(N):
    X = deque(input().rstrip())
    stack = []
    check = False

    while X:
        if X[0] == '(':
            stack.append(1)
            X.popleft()
        elif X[0] ==')':
            if len(stack)==0:
                break
            else :
                stack.pop()
                X.popleft()

    if len(X) == 0 and len(stack) == 0:
        check = True

    if check :
        print("YES")
    else :
        print("NO")

