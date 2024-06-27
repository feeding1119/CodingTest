class Solution {
    
    static int index = 0;
    static int answer = 0;
    
    static String[] w = {"A","E","I","O","U"};
    public int solution(String word) {
        String start = "";
        findWord(start,word);
        
        return answer;
    }
    
    public void findWord(String word,String findWord){
        if(word.length() == 5){
            return;
        }
        
        for(int i=0;i<5;i++){
            String newWord = word + w[i];
            index++;
            
            if(newWord.equals(findWord)){
                answer = index;
                return;
            }
            
            findWord(newWord,findWord);
         
        }
    }
}