class Solution {
    
    static long answer = 0;
    public long solution(int n, int[] times) {
        dfs(0L,10000000000001L,n,times);
        return answer;
    }
    
    private void dfs(long start,long end,int n,int[] times){
        if(start>=end) return;
        
        long mid = (start+end)/2;
        
        long v = checkNum(mid,times);
        
        if(v >= n){
            answer = mid;
            dfs(start,mid,n,times);
        }else dfs(mid+1,end,n,times);
        
    }
    
    private long checkNum(long mid,int[] times){
        long total = 0;
        
        for(int i=0;i<times.length;i++){
            total += mid/times[i];
        }
        
        return total;
    }
}