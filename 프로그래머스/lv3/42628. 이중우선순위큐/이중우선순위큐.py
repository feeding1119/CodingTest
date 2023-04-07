from heapq import heappush, heappop

def solution(operations):
    heap=[]
    for i in operations:
        if i[0] == 'I':
            text = i.strip('I ')
            heap.append(int(text))
            heap.sort()
        elif i == 'D -1' :
            if len(heap) != 0 :
                heap.pop(0)
                
        elif i == 'D 1' :
            if len(heap) != 0 :
                heap.pop(-1)
            
                

    if len(heap) == 0 :
        return [0,0]
    else :
        return [heap[-1],heap[0]]
    