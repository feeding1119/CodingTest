import sys

input = sys.stdin.readline

N,M,R= map(int,input().split())
board = []

for _ in range(N) :
    board.append(input().split())


for i in range(R):
    s = min(N,M)//2
    for j in range(s):
        x,y = j,j
        pre = board[j][j]

        for k in range(x+1,N-j):
            temp = board[k][j]
            board[k][j] = pre
            pre = temp

        for k in range(y+1,M-j):
            temp = board[N-1-j][k]
            board[N-1-j][k]=pre
            pre = temp

        for k in range(N-j-2,j-1,-1):
            temp = board[k][M-j-1]
            board[k][M-j-1] = pre
            pre = temp

        for k in range(M-j-2,j-1,-1):
            temp = board[j][k]
            board[j][k] =pre
            pre = temp

for i in range(N):
    for j in range(M):
        print(board[i][j],end=' ')
    print()