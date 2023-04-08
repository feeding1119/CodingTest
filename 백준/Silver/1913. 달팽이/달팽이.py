n = int(input())
k = int(input())
count = 0
board = [[0]*n for _ in range(n)] # 처음에는 [[0]*n]*n으로 선언했다가 얕은 복사 때문에 수정

x = (n-1)//2
y = (n-1)//2
board[x][y]=1
mx,my = 0,0
cnt_up, cnt_down, cnt_left, cnt_right = 2,2,2,1
start = 3
i = 2
while x!=0 or y!=0:
    while i <= start*start:

        if x==y==(n-1)//2:
            x -=1


        elif cnt_right>0:
            y += 1
            cnt_right -= 1

        elif cnt_down>0:
            x += 1
            cnt_down -= 1

        elif cnt_left>0:
            y -= 1
            cnt_left -= 1

        elif cnt_up>0:
            x -= 1
            cnt_up -= 1


        board[x][y] = i
        i+=1

    n -= 2
    start += 2
    cnt_up, cnt_down, cnt_left, cnt_right = start-1,start-1,start-1,start-2

for i in range(len(board)):
    for j in range(len(board)):
        print(board[i][j],end=' ')
        if board[i][j] == k:
            mx=i+1
            my=j+1
    print()
print(mx,my)