class Solution {
    
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        
        dfs(k,dungeons,0,new boolean[len],len,0);
        
        return answer;
    }
    
    private void dfs(int k,int[][] d,int count,boolean[] isVisited,int len,int index){
        if(index == len || k == 0){
            if(count > answer) answer = count;
            return;
        }
        
        for(int i=0;i<len;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                if(k >= d[i][0]) dfs(k-d[i][1],d,count+1,isVisited,len,index+1);
                else dfs(k,d,count,isVisited,len,index+1);
                isVisited[i] = false;
            }
        }
        
    }
}