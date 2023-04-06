n = int(input())
d = list(map(int,input().split()))
m = list(map(int,input().split()))

mm = m[0]
total = 0

for i in range(n-1):
    if m[i] < mm :
        mm = m[i]

    total += mm*d[i]

print(total)
