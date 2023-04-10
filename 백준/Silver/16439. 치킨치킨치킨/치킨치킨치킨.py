from itertools import combinations
import sys

input = sys.stdin.readline

N,M = map(int,input().split())

total_max = 0

chi = [list(map(int,input().split())) for _ in range(N)]

allchi = list(combinations(range(M),3))

for a,b,c in allchi:
    total = 0
    for i in range(N):
        total += max(chi[i][a],chi[i][b],chi[i][c])
    total_max = max(total,total_max)

print(total_max)