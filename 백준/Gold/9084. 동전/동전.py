import sys

input = sys.stdin.readline

T = int(input())
printlist =[]

for _ in range(T):
    
    N = int(input())
    coinlist = list(map(int,input().split()))
    M = int(input())
    
    d = [0]*(M+1)
    d[0]=1
    
    for i in range(N):
        for j in range(coinlist[i],M+1):
            d[j] += d[j-coinlist[i]]
    
    print(d[M])