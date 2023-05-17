import sys

input = sys.stdin.readline

N,M = map(int,input().split())

answer = []
find = []
count = 0

for i in range(N):
    answer.append(input().rstrip())

for i in range(M):
    find.append(input().rstrip())

for f in find:
    if f in answer:
        count += 1

print(count)

