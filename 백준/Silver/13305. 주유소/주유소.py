n = int(input())
d = list(map(int,input().split()))
m = list(map(int,input().split()))

mm = 10001
total = 0


for i in range(len(m)-1):
    if m[i] < mm :
        mm = m[i]
        if m[i] == 1:
            total += mm*sum(d[i:])
            break
    total += mm*d[i]

print(total)


