
def solution(x, y, n):
    dp = [float('inf')]*(y+1)
    
    dp[x] = 0
    
    for i in range(x+1,y+1):
        minNum = float('inf')
        
        if i%2 == 0:
            minNum = min(minNum,dp[int(i/2)])
                
        if i%3 == 0:
            minNum = min(minNum,dp[int(i/3)])            
                
        if i>n :
            minNum = min(minNum,dp[i-n])
                
        if not minNum == float('inf'):
            dp[i] = minNum+1
            
    
    if dp[y] == float('inf'):
        return -1
    
    else :
        return dp[y]
    