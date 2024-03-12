/**
1. 주어진 직선의 교점에 별을 찍는다.
2. 교점은 정수로만 표현되는 좌표이다.
3. 주어진 교점에 점을 찍고, 이 교점을 모두 포함하는 가장 작은 직사각형을 리턴한다.
**/
import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        
        String[] answer = {};
        List<long[]> cross = create(line);
        long top = Long.MIN_VALUE;
        long bottom = Long.MAX_VALUE;
        long left = Long.MAX_VALUE;
        long right = Long.MIN_VALUE;
        
        for(long[] next : cross){
            top = Long.max(top, next[0]);
            bottom = Long.min(bottom, next[0]);
            left = Long.min(left, next[1]);
            right = Long.max(right, next[1]);
        }
       
        int hight = (int) (top - bottom + 1);
        int width = (int) (right - left + 1);
        
        char[][] map = new char[hight][width];
        
        for(char[] next : map) Arrays.fill(next,'.');
        
        for(long[] next : cross){
            
            int y = (int)(top - next[0]);
            int x = (int)(next[1] - left);
            map[y][x] = '*';
            
        }
        answer = new String[map.length];
        
        int idx = 0;
        for(char[] ne : map){
            answer[idx] = new String(map[idx]);
            idx++;
        }
        
        return answer;
    }
    
    List<long[]> create(int[][] line){
        List<long[]> list = new ArrayList<>();
        for(int i=0; i<line.length; i++){
            int[] a = line[i];
            for(int j=i+1; j<line.length; j++){
                int[] b = line[j];
                
                double x = (((long)a[1] * (long)b[2]) - ((long)a[2] * (long)b[1])) * 1.0 / (((long)a[0] * (long)b[1]) - ((long)a[1] * (long)b[0])) * 1.0;
                double y = (((long)a[2] * (long)b[0]) - ((long)a[0] * (long)b[2])) * 1.0 / (((long)a[0] * (long)b[1]) - ((long)a[1] * (long)b[0])) * 1.0;
                
                if(x %1 ==0 && y%1 == 0){
                    list.add(new long[]{(long)y, (long)x});
                }
            }
        }
        
        return list;
        
    }
    
}