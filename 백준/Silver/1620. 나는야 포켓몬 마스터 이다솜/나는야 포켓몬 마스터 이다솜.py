import sys

input = sys.stdin.readline

N,M = map(int,input().split())

pkList = {}
answer = []

for i in range(1,N+1):
    pk = input().rstrip()
    pkList[i] = pk
    pkList[pk] = i

for i in range(M):
    answer.append(input().rstrip())

for ans in answer:
    if ans.isdigit():
        print(pkList[int(ans)])
    else :
        print(pkList[ans])


