import sys

input = sys.stdin.readline

n = int(input())

Colors = input().rstrip()

Rcount = 0
Bcount = 0
prev = Colors[0]

for color in Colors[1:]:
    if prev != color:
        if color == 'B':
            Rcount += 1
            prev = 'B'
        elif color == 'R':
            Bcount += 1
            prev = 'R'

if Colors[-1] == 'B':
    Bcount += 1
elif Colors[-1] == 'R':
    Rcount += 1
    
if Bcount > Rcount :
    print(Rcount+1)
else :
    print(Bcount+1)