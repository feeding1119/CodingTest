class Solution {
    
    static int zeroCount = 0;
    public int[] solution(String s) {
        int transCount = 0;
        
        String currentString = s;
        while(true){
            currentString = binaryTrans(currentString);
            transCount++;
            if(currentString.equals("1")){
                break;
            }
        }
        
        int[] answer = {transCount,zeroCount};
        return answer;
    }
    
    public String binaryTrans(String x){
        int count = 0;
        
        for(int i=0;i<x.length();i++){
            if(x.charAt(i) == '1') count++;
        }
        
        zeroCount += x.length() - count;
        
        return lenToBinary(count);
        
    }
    
    public String lenToBinary(int count){
        String result = "";
        while(count >1){
            result += count%2;
            count /= 2;
        }
        result += count;
        
        String reverseResult = "";
        for(int i=result.length()-1;i>=0;i--){
            reverseResult += result.charAt(i);
        }
        
      
        return reverseResult;
        
    }
}