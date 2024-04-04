import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Map<Integer,Double> map = new HashMap();
        
        for(int i=1;i<=N;i++){
            double failRate = 0;
            double stageFail = 0;
            double stageArrival= 0;
            
            for(int j=0;j<stages.length;j++){
                if(stages[j] == i){
                    stageFail++;
                }
                if(stages[j] >= i){
                    stageArrival++;
                }
            }
            
            if(stageArrival == 0) map.put(i,0.0);
            else map.put(i,stageFail/stageArrival);
        }
        
        List<Integer> keySet = new ArrayList<Integer>(map.keySet());
        keySet.sort((o1,o2)-> map.get(o2).compareTo(map.get(o1)));
        for (int i=0;i<N;i++) {
            answer[i]=keySet.get(i);
        }
        return answer;
    }
}