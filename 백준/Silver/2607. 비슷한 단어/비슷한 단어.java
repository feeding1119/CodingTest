
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        String word = br.readLine();

        int[] arr = new int[26];

        for(int i=0;i<word.length();i++){
            arr[word.charAt(i)-'A']++;
        }

        for(int i=1;i<n;i++){
            String temp = br.readLine();

            int[] tempArr = new int[26];

            for(int j=0;j<temp.length();j++){
                tempArr[temp.charAt(j)-'A']++;
            }

            int count = 0;
            for(int j=0;j<26;j++){
                count += Math.abs(arr[j]-tempArr[j]);
            }

            if(count <= 1) answer++;
            if(word.length() == temp.length() && count == 2) answer++;
        }

        System.out.println(answer);

    }
}
