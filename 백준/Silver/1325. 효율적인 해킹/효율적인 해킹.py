import sys
from collections import deque

input = sys.stdin.readline

n,m =map(int,input().split())

bfs_graph = [[] for i in range(n+1)]
bfs_answer = [0]*(n+1)

for i in range(m):
    a,b = map(int,input().split())
    bfs_graph[b] += [a]


def bfs(start):
    bfs_visited = [0] * (n + 1)

    count =0
    bfs_visited[start] = 1
    Q = deque([start])
    while Q:
        c = Q.popleft()
        count += 1
        for nx in bfs_graph[c]:
            if bfs_visited[nx] == 0:
                bfs_visited[nx] = 1
                Q.append(nx)
    return count

for i in range(1,n+1):
    bfs_answer[i] = bfs(i)

for j in range(1,n+1):
    if bfs_answer[j] == max(bfs_answer):
        print(j, end= ' ')