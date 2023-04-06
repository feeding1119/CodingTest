n = int(input())
d = list(map(int,input().split()))
m = list(map(int,input().split()))

mm = 10001
rindex = len(d)
lindex = len(m)-1
total = 0

while lindex != 0:
    for i in range(lindex):
        if mm > m[i] :
            mm = m[i]
            lindex = i
            if mm == 1:
                break

    total += mm*(sum(d[lindex:rindex]))
    rindex = lindex
    mm = 10001

print(total)


