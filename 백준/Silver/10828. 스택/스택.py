import sys

input = sys.stdin.readline

N= int(input())
stack = []

for i in range(N):
    x = input().rstrip()
    if x[:4] == 'push':
        stack.append(x.split()[1])
    elif x[:3] == 'pop':
        if(len(stack)==0):
            print(-1)
        else:
            print(stack.pop())
    elif x[:4] == 'size':
        print(len(stack))
    elif x[:5] == 'empty':
        if(len(stack)==0):
            print(1)
        else :
            print(0)
    elif x[:3] == 'top':
        if(len(stack)==0):
            print(-1)
        else:
            print(stack[-1])
