class Solution {
    
    static int answer = 0;
    static int n;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        
        dfs(0,0,target,numbers);
            
        return answer;
    }
    
    public void dfs(int count , int total, int target,int[] numbers){
        if(count == n){
            if(total == target) answer++;
            return;
        }
        
        dfs(count+1,total+numbers[count],target,numbers);
        dfs(count+1,total-numbers[count],target,numbers);
    }
}