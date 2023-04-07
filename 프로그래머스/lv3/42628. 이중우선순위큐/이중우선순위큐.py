import heapq

def solution(operations):
    minheap = []
    maxheap = []
    count = 0
    check = [1] * len(operations)
    for i in operations:
        
        if i[0] == 'I':
            text = i.strip('I ')
            heapq.heappush(minheap,(int(text),count))
            heapq.heappush(maxheap,(-int(text),count))
        
        else :
            if len(minheap) == 0 or len(maxheap) == 0:
                pass
            elif i == 'D -1' :
                check[heapq.heappop(minheap)[1]] = 0
            
            elif i == 'D 1' :
                check[heapq.heappop(maxheap)[1]] = 0
                
        
        while minheap and check[minheap[0][1]] == 0:
            heapq.heappop(minheap)
        while maxheap and check[maxheap[0][1]] == 0:
            heapq.heappop(maxheap)
            
        count += 1
        
    if len(minheap) == 0 or len(maxheap) ==0: 
        return [0,0]
    else :
        return [-maxheap[0][0],minheap[0][0]]
    