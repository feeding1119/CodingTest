from collections import deque
import sys

input = sys.stdin.readline

n,m,v= map(int,input().split())

dfs_graph = [[] for i in range(n+1)]
dfs_visited = [0]*(n+1)
dfslist = []

bfs_graph = [[] for i in range(n+1)]
bfs_visited = [0]*(n+1)
bfslist =  []


for i in range(m):
    a,b = map(int,input().split())
    dfs_graph[a] += [b]
    dfs_graph[b] += [a]
    bfs_graph[a] += [b]
    bfs_graph[b] += [a]

for s in range(n+1):
    dfs_graph[s].sort()
    bfs_graph[s].sort()
    
bfs_visited[v] = 1
Q = deque([v])
bfslist.append(v)

while Q:
    c = Q.popleft()
    for nx in bfs_graph[c]:
        if bfs_visited[nx] == 0:
            bfslist.append(nx)
            Q.append(nx)
            bfs_visited[nx] = 1


def dfs(v):
    dfs_visited[v]=1
    dfslist.append(v)
    for nx in dfs_graph[v]:
        if dfs_visited[nx]==0:
            dfs(nx)

dfs(v)

print(" ".join(str(i) for i in dfslist))
print(" ".join(str(i) for i in bfslist))

