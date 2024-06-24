def solution(array, commands):
    
    answer = []
    for i in range(len(commands)):
        ls = array[commands[i][0]-1:commands[i][1]]
        ls.sort()
        answer.append(ls[commands[i][2]-1])
    return answer