from itertools import combinations

cal = input()
answer=[]

lcount = []
tcount = []
for i in range(len(cal)):
    if cal[i] == '(' :
        lcount.append(i)
    elif cal[i] == ')' :
        tcount.append([lcount.pop(),i])

for i in range(1,len(tcount)+1):
    tcombi = combinations(tcount,i)
    for j in tcombi:
        s = list(cal)
        for k in j:
            a,b = k
            s[a]=''
            s[b]=''
        answer.append(''.join(s))

for i in sorted(set(answer)):
    print(i)
