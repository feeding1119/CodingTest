def solution(targets):
    targets.sort()
    count = 1
    leftRange = targets[0][0]
    rightRange = targets[0][1]
    
    for i in range(1,len(targets)):
        if rightRange <= targets[i][0] :
            rightRange = targets[i][1]
            count += 1
        else :
            rightRange = min(rightRange,targets[i][1])
            
        
    return count