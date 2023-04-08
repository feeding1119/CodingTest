from collections import deque
import sys

input = sys.stdin.readline

n =int(input())

dfs_graph = [[] for i in range(n+1)]
dfs_visited = [0]*(n+1)

bfs_graph = [[] for i in range(n+1)]
bfs_visited = [0]*(n+1)


for i in range(n-1):
    a,b = map(int,input().split())
    dfs_graph[a] += [b]
    dfs_graph[b] += [a]
    bfs_graph[a] += [b]
    bfs_graph[b] += [a]

bfs_visited[1] = 1
Q = deque([1])

while Q:
    c = Q.popleft()
    for nx in bfs_graph[c]:
        if bfs_visited[nx] == 0:
            Q.append(nx)
            bfs_visited[nx] = c


def dfs(v):
    for nx in dfs_graph[v]:
        if dfs_visited[nx]==0:
            dfs_visited[nx] = v
            dfs(nx)



# for i in dfs_visited[2:]:
#     print(i)

for i in bfs_visited[2:]:
    print(i)
    


