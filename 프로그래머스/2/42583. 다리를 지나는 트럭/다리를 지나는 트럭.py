from collections import deque

def solution(bridge_length, weight, truck_weights):
    check_list = []
    count_list =[]
    dq = deque(truck_weights)
    time = 1 
    
    check = 0

    while len(dq) + len(check_list) != 0:
        count = 0
        time += 1
        if len(dq) != 0:
            check_list.append([dq.popleft(),0])
        
        for i in range(len(check_list)):
            count += check_list[i][0]
        
        if  len(check_list) > bridge_length or count > weight:
            a = check_list.pop()
            dq.appendleft(a[0])
        
        for j in range(len(check_list)) :
            check_list[j][1] += 1
            if check_list[j][1] == bridge_length:
                check += 1
        
        if check > 0 :
            for i in range(check):
                check_list.pop(0)
                check -= 1
            
    return time