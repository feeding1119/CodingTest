def solution(numbers, target):
    n = len(numbers)
    answer = 0
    
    def dfs(idx,nums):
        if idx == n:
            if nums == target :
                nonlocal answer
                answer += 1
        
        else :
            dfs(idx+1,nums+numbers[idx])
            dfs(idx+1,nums-numbers[idx])
    
    dfs(0,0)
    return answer