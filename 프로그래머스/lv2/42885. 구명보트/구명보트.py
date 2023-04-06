from collections import deque

def solution(people, limit):
    
    people.sort(reverse=True)
    dq = deque(people)
    add_check = 0
    count = 0
    
    
    while len(dq) != 0:
        if add_check == 0 :
            add_check += dq[0]
            dq.popleft()
            if len(dq) == 0 :
                count += 1
        else : 
            add_check += dq[-1]
            if add_check > limit :
                add_check = 0
                count += 1
            else :
                add_check = 0
                count += 1
                dq.pop()
    return count