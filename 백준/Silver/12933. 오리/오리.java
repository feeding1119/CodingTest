import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");
        HashMap<String,Integer> findStr = new HashMap<>();
        findStr.put("q",1);
        findStr.put("u",2);
        findStr.put("a",3);
        findStr.put("c",4);
        findStr.put("k",5);
        findStr.put("_",6);

        int totalCount = 0;
        List<Integer> tempIndex = new ArrayList<>();



         while(true){
             int prevPointer = 0;
             boolean count = false;

            for(int i=0;i<input.length;i++){
                if(!findStr.containsKey(input[i])){
                    totalCount = -1;
                    break;
                }
                if(findStr.get(input[i])-1 == prevPointer){
                    tempIndex.add(i);
                    prevPointer++;
                }

                if(prevPointer == 5){
                    prevPointer = 0;
                    for(int index : tempIndex){
                        input[index] ="_";
                    }
                    tempIndex.clear();
                    count =true;
                }
            }

            if(count&&prevPointer==0){
                totalCount++;
            }else {
                break;
            }

         }

         for(String str : input){
             if(str != "_"){
                 totalCount = -1;
                 break;
             }
         }

        System.out.println(totalCount);

    }

}
