import heapq
import sys

input = sys.stdin.readline
T = int(input())

for i in range(T):
    minheap = []
    maxheap = []

    k = int(input())
    check = [1]*k
    for j in range(k):
        n,m = input().split()

        if n == 'I':
            heapq.heappush(minheap,(int(m),j))
            heapq.heappush(maxheap,(-int(m),j))
        else :
            if len(minheap) == 0 or len(maxheap) == 0:
                pass
            elif m == '-1':
                check[heapq.heappop(minheap)[1]] = 0
            else :
                check[heapq.heappop(maxheap)[1]] = 0

        while minheap and check[minheap[0][1]] == 0:
            heapq.heappop(minheap)
        while maxheap and check[maxheap[0][1]] == 0:
            heapq.heappop(maxheap)

    if len(minheap) == 0 or len(maxheap) ==0:
        print('EMPTY')
    else :
        print(-maxheap[0][0],minheap[0][0])