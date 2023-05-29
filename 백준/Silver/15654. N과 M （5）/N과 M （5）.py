import sys

input = sys.stdin.readline

N,M = map(int,input().split())
numlist = list(map(int,input().split()))
answer = []
numlist.sort()

def dfs():
    if len(answer) == M:
        print(' '.join(map(str,answer)))
        return
    for i in numlist:
        if i not in answer:
            answer.append(i)
            dfs()
            answer.pop()

dfs()