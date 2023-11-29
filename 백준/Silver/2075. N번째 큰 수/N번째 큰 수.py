import sys
import heapq
input = sys.stdin.readline

N = int(input())

heap = []

for _ in range(N):
    numbers = list(map(int,input().split()))
    for number in numbers:
        if len(heap) < N:
            heapq.heappush(heap,number)
        elif heap[0] < number:
            heapq.heappop(heap)
            heapq.heappush(heap,number)

print(heapq.heappop(heap))
