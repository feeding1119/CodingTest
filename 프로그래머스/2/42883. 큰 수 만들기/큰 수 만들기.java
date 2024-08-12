class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        String[] num = new String[number.length()];
        
        int count = k;
        
        for(int i=0;i<number.length();i++){
            num[i] = Character.toString(number.charAt(i));
        }
        
        int start =0;
        
        while(count >0){
            int maxValue = -1;
            int maxIndex = 0;

            if(number.length()-start == count){
                start += count;
                break;
            }
            for(int i=start;i<=start+count;i++){
                if(maxValue < Integer.parseInt(num[i])){
                    maxValue = Integer.parseInt(num[i]);
                    maxIndex = i;
                    if(maxValue == 9) break;
                }
            }
            answer += num[maxIndex];
            count -= maxIndex-start;
           
            start = maxIndex+1;
            
        }
        
        if(start < number.length()) {
            for(int i=start;i<number.length();i++){
                answer += num[i];
            }
        }
        return answer;
    }
}