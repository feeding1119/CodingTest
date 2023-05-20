import sys
from collections import deque
from heapq import heappop,heappush

input = sys.stdin.readline

n = int(input())

num = []
dq = deque(num)
check = []
answer = []
k = 1
for i in range(n):
    dq.append(int(input()))

check.append(k)
answer.append("+")
k += 1

while dq:
    if len(check) !=0 and check[-1] > dq[0]:
        print("NO")
        break
    else :
        if len(check) !=0 and check[-1] == dq[0] :
            dq.popleft()
            answer.append("-")
            check.pop()
        else :
            check.append(k)
            k += 1
            answer.append("+")


if len(dq) == 0:
    for ans in answer:
        print(ans)