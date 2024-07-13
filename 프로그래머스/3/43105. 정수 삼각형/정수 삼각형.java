class Solution {
    public int solution(int[][] triangle) {
        int triSize = triangle.length;
        int[][] dp = new int[triSize+1][triSize+1];
        
        dp[1][1] = triangle[0][0];
        
        for(int i = 2;i <= triSize ; i++){
            for(int j=1; j<=i;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i-1][j-1];
            }
        }
        
//         for(int i=0;i<=triSize;i++){
//             for(int j=0;j<=triSize;j++){
//                 System.out.print(dp[i][j]+" ");
//             }
            
//             System.out.println();
//         }
        
        int answer = 0;
        
        for(int i=0; i<=triSize; i++){
            if(answer < dp[triSize][i]) answer = dp[triSize][i];
        }
        return answer;
    }
}