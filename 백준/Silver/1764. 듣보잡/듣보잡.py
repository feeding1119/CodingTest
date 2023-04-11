import sys

input = sys.stdin.readline

N,M = map(int,input().split())

count = 0

lp = [input().strip() for _ in range(N)]
rp = [input().strip() for _ in range(M)]
lp = set(lp)
rp = set(rp)
person = []

person = sorted(list(lp & rp))

print(len(person))
for pe in person:
    print(pe)