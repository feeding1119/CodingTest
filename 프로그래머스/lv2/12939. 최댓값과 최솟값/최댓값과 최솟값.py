def solution(s):
    ls = s.split()
    
    for i in range(len(ls)):
        ls[i] = int(ls[i])
        
    return str(min(ls))+" "+str(max(ls))