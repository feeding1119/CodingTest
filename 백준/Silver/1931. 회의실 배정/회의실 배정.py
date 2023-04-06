n = int(input())
mlist = []
count = 1

for i in range(n):
    mlist.append(list(map(int, input().split())))

mlist.sort(key=lambda x:(x[1],x[0]))

check = mlist[0][1]

for i in mlist[1:]:
    if check <= i[0]:
        count += 1
        check = i[1]

print(count)
