n,k= map(int,input().split())
data = list(map(int, input().split()))

data.sort()
sublist = []

for i in range(1,len(data)):
    sublist.append(data[i]-data[i-1])
    
sublist.sort()
print(sum(sublist[:n-k]))
