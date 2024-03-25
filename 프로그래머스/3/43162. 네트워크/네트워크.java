class Solution {
    
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,n,computers);
                answer++;
            }
        }
        return answer;
    }
    
    private static void dfs(int start,int n,int[][] computers){
        visited[start] = true;
        
        for(int i=0;i<n;i++){
            if(!visited[i] && computers[start][i]==1){
                dfs(i,n,computers);
            }
        }
    }
}