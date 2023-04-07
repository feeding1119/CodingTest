import heapq

def solution(operations):
    minheap = []
    maxheap = []
    count = 0
    check = 0
    
    for i in operations:
        if i[0] == 'I':
            text = i.strip('I ')
            heapq.heappush(minheap,int(text))
            heapq.heappush(maxheap,-int(text))
            count += 1
        
        else :
            if len(minheap) == 0 or len(maxheap) == 0:
                pass
            elif i == 'D -1' :
                heapq.heappop(minheap)
                check += 1
            elif i == 'D 1' :
                heapq.heappop(maxheap)
                check += 1
        if count == check :
            minheap = []
            maxheap = []
            count = 0
            check = 0        
        print(minheap)
        print(maxheap)
        
    if len(minheap) == 0 or len(maxheap) ==0: 
        return [0,0]
    else :
        return [-maxheap[0],minheap[0]]
    