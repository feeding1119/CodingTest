#include <iostream> 
#include <queue>
using namespace std;
 
int N,K;
queue<int>q;

int main(void)
{
        cin >> N >> K;
        
        for(int i=1;i<=N;i++) q.push(i);

        cout << "<";

        for(int i=0;i<N;i++){
            int count = 0;

            while(q.size() != 0){
                count++;
                if(count == K) break;

                q.push(q.front());
                q.pop();
            }

            cout << q.front();
            if(q.size() != 1) cout << ", ";
            q.pop();
        }
        cout << ">";
        
        return 0;
}