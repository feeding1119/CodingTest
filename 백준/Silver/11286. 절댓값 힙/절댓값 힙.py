import sys
import heapq

input = sys.stdin.readline

N = int(input())

plusHeap = []
minusHeap = []

for _ in range(N):
    number = int(input())
    if number > 0 :
        heapq.heappush(plusHeap,number)
    elif number < 0 :
        heapq.heappush(minusHeap,-number)
    else :
        if len(plusHeap) == 0 and len(minusHeap) == 0:
            print(0)
        elif len(plusHeap) == 0:
            print(-heapq.heappop(minusHeap))
        elif len(minusHeap) == 0:
            print(heapq.heappop(plusHeap))
        else :
            plusNumber = heapq.heappop(plusHeap)
            minusNumber = heapq.heappop(minusHeap)

            if plusNumber >= minusNumber:
                print(-minusNumber)
                heapq.heappush(plusHeap,plusNumber)
            else :
                print(plusNumber)
                heapq.heappush(minusHeap,minusNumber)
