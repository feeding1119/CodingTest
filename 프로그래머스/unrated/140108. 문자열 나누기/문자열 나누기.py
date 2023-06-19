def solution(s):
    save = ''
    s_count = 0
    d_count = 0
    total = 0
    
    for i in s:
        if save == '':
            save = i
            s_count+=1
        elif save == i :
            s_count+=1
        else :
            d_count+=1
        
        if s_count == d_count:
            total += 1
            save = ''
            s_count = 0
            d_count = 0
    
    if not save == '':
        total += 1
    return total