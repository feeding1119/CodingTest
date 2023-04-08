import sys

input = sys.stdin.readline

s = list(input())

ans_list = []
ans = ''
idx = 0
incheck = 0
while len(s) != idx:
    if s[idx] == '<':
        if ans != '':
            ans_list.append(ans[::-1])
            ans = ''
        ans +=s[idx]
        incheck = 1
    elif s[idx] == '>':
        ans +=s[idx]
        ans_list.append(ans)
        ans = ''
        incheck =0
    elif s[idx] == ' ' and incheck ==0 :
        ans_list.append(ans[::-1])
        ans_list.append(' ')
        ans = ''
    elif s[idx] == '\n':
        ans_list.append(ans[::-1])
        ans = ''
    else:
        ans += s[idx]

    idx += 1


print(''.join(ans_list))