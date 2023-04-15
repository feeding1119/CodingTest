import sys

input = sys.stdin.readline

N = int(input())

if N >= 5:
    if (N%5)%3 == 0:
        print((N//5)+(N%5)//3)
    elif (N%5)%3==2 and N>=10:
        print((N//5)-2+((N%5)+10)//3)
    elif ((N%5)+5)%3==0:
        print(((N//5)-1+((N%5)+5)//3))
    else :
        print(-1)
elif N==3:
    print(1)
else :
    print(-1)
