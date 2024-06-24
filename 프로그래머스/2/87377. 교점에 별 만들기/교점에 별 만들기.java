import java.util.*;

class Solution {
    static List<Long[]> coordinates = new ArrayList<>();
    static Long maxX = Long.MIN_VALUE;
    static Long maxY = Long.MIN_VALUE;
    static Long minX = Long.MAX_VALUE;
    static Long minY = Long.MAX_VALUE;
    
    public String[] solution(int[][] line) {
        
        for(int i=0; i<line.length;i++){
            for(int j=i+1;j<line.length;j++){
                if(checkXY(line[i],line[j])){
                    calcXY(line[i],line[j]);
                }
            }
        }
        
        
        long Xsize = maxX - minX + 1;
        long Ysize = maxY - minY + 1;
        
        
        String[][] result = new String[(int)Ysize][(int)Xsize];
        
        for(int i=0;i<coordinates.size();i++){
            long nx = (coordinates.get(i)[0]-minX);
            long ny = Ysize -1 -(coordinates.get(i)[1]-minY);
            
            result[(int)ny][(int)nx] = "*";
        }
        
        String[] answer = new String[(int)Ysize];
        
        for(int i=0;i<Ysize;i++){
            String temp = "";
            for(int j=0;j<Xsize;j++){
                if(result[i][j] != null) temp+="*";
                else temp+=".";
            }
            answer[i] = temp;
        }
        return answer;
    }
    
    public boolean checkXY(int[] a,int[] b){
        int A = a[0];
        int B = a[1];
        int C = b[0];
        int D = b[1];
        int E = a[2];
        int F = b[2];
        
        if(A*D-B*C == 0) return false;
        return true;
    }
    public void calcXY(int[] a, int[] b){
        double A = a[0];
        double B = a[1];
        double C = b[0];
        double D = b[1];
        double E = a[2];
        double F = b[2];
        
        double X = (B*F-E*D)/(A*D-B*C);
        double Y = (E*C-A*F)/(A*D-B*C);
        
        if(X == (long)X && Y ==(long) Y) {
            coordinates.add(new Long[]{(long)X,(long)Y});
            
            if((long)X > maxX) maxX = (long)X;
            if((long)X < minX) minX = (long)X;
            if((long)Y > maxY) maxY = (long)Y;
            if((long)Y < minY) minY = (long)Y;
        }
        
  
    }
}