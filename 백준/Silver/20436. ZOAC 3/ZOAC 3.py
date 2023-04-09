dic1 = {'z':(0,0),'x':(1,0),'c':(2,0),'v':(3,0),'a':(0,1),'s':(1,1),'d':(2,1),'f':(3,1),
        'g':(4,1),'q':(0,2),'w':(1,2),'e':(2,2),'r':(3,2),'t':(4,2)}

dic2 = {'b':(0,0),'n':(1,0),'m':(2,0),'h':(1,1),'j':(2,1),'k':(3,1),'l':(4,1),'y':(1,2),
        'u':(2,2),'i':(3,2),'o':(4,2),'p':(5,2)}

count = 0

sl,sr = input().split()

s = input()
count += len(s)

for i in range(len(s)):
    if s[i] in dic1:
        count+= abs(dic1.get(sl)[0]-dic1.get(s[i])[0])+abs(dic1.get(sl)[1]-dic1.get(s[i])[1])
        sl = s[i]
    elif s[i] in dic2:
        count += abs(dic2.get(sr)[0] - dic2.get(s[i])[0]) + abs(dic2.get(sr)[1] - dic2.get(s[i])[1])
        sr = s[i]

print(count)