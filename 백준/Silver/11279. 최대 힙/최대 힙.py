import sys
from heapq import heappop,heappush
input = sys.stdin.readline

heap = []

N= int(input())

for i in range(N):
    x = int(input())
    if x == 0:
        if(len(heap) == 0):
            print(0)
        else :
            print(heappop(heap)[1])

    else :
        heappush(heap,(-x,x))
