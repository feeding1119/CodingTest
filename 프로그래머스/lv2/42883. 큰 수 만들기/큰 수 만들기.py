def solution(number, k):
    answer = ''
    index = 0
    max = 0
    check = k
    check_idx = 0
    
    while len(answer) != len(number)-k:
        check_idx = index
        for i in range(index,index+check+ 1):
                if max < int(number[i]):
                    max = int(number[i])
                    index = i+1
                    if max == 9 :
                        break

        check -= index-check_idx-1
            
        answer += str(max)
        max = 0
    
    return answer