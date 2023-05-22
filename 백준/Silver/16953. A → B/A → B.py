import sys

input = sys.stdin.readline

A,B = map(int,input().split())
cnt = 1

while A < B:
    if B%10 == 1:
        B = int(B/10)
        cnt+=1
    elif B%2 != 0:
        break
    else :
        B = int(B/2)
        cnt+=1

if A==B:
    print(cnt)
else :
    print(-1)