N = int(input())

stairs = []

for _ in range(N):
    stairs.append(int(input()))

dp = [0] * (N+1)

dp[0] = 0
dp[1] = stairs[0]

if(N>1) :
    dp[2] = stairs[0] + stairs[1]

for i in range(3,N+1):
    dp[i] = stairs[i-1] + max(dp[i-2],stairs[i-2]+dp[i-3])

print(dp[N])