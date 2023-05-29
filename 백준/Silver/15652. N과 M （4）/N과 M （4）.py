import sys

input = sys.stdin.readline

N,M = map(int,input().split())
answer = []

def dfs():
    if len(answer) == M:
        print(' '.join(map(str,answer)))
        return
    for i in range(1,N+1):
        if len(answer) == 0:
            answer.append(i)
            dfs()
            answer.pop()
        elif i >= answer[-1] :
            answer.append(i)
            dfs()
            answer.pop()

dfs()
