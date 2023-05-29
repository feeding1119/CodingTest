import sys

input = sys.stdin.readline

N,M = map(int,input().split())
numlist = list(map(int,input().split()))
answer = []
numlist.sort()

def dfs(start):
    if len(answer) == M:
        print(' '.join(map(str,answer)))
        return
    for i in range(start,N):
        if numlist[i] not in answer:
            answer.append(numlist[i])
            dfs(i)
            answer.pop()

dfs(0)
