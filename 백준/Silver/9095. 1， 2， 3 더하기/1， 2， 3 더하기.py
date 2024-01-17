T = int(input())

num_list = []

for _ in range(T):
    n = int(input())

    if(n==1):
        print(1)
        continue
    dp = [1] * (n+1)

    dp[2] = 2

    for i in range(3,n+1):
        dp[i] = dp[i-3] + dp[i-2] + dp[i-1]

    print(dp[n])