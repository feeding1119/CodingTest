import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;

    static int[] arr;
    static boolean[] visited;

    static List<Integer> resultArr = new ArrayList<>();
    static boolean[] resultVisted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        resultVisted = new boolean[N+1];

        arr = new int[N+1];

        for(int i=1; i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1;i<=N;i++){
            visited = new boolean[N+1];
            dfs(i);
            if(compareArr()){
                for(int j=0;j<=N;j++){
                    if(visited[j]){
                        resultVisted[j] =true;
                    }
                }
            }
        }

        for(int i=0;i<=N;i++){
            if(resultVisted[i]){
                resultArr.add(i);
            }
        }

        Collections.sort(resultArr);

        System.out.println(resultArr.size());
        for(int i=0;i<resultArr.size();i++){
            System.out.println(resultArr.get(i));
        }


    }

    static void dfs(int index){
        visited[index]=true;
        if(!visited[arr[index]]){
            dfs(arr[index]);
        }
    }

    static boolean compareArr(){
        List<Integer> firstArr = new ArrayList<>();
        List<Integer> secondArr = new ArrayList<>();

        for(int i=1;i<=N;i++){
            if(visited[i]){
                firstArr.add(i);
                secondArr.add(arr[i]);
            }
        }
        Collections.sort(firstArr);
        Collections.sort(secondArr);

        for(int i=0;i<firstArr.size();i++){
            if(firstArr.get(i) != secondArr.get(i)) return false;
        }

        return true;
    }
}
