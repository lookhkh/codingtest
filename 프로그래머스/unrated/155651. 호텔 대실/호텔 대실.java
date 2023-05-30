import java.util.*;
import java.util.Arrays;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];  
        
        int cnt = 0;
        for(String[] book : book_time){
            time[cnt][0] = convertToTime(book[0]);
            time[cnt][1] = convertToTime(book[1]);
            cnt++;   
        }
        
        Arrays.sort(time,(t1,t2)->Integer.compare(t1[0],t2[0]));
        
        PriorityQueue<Integer> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1,t2));
        
        for(int[] next : time){
            if(que.isEmpty()){
                que.add(next[1]+10);
                answer++;
            }else{
                if(que.peek()<= next[0]) {
                    que.add(next[1]+10);
                    que.poll();
                    continue;
                }
                
                else{
                    que.add(next[1]+10);
                    answer++;
                }
                
                
            }
            
        }
        
        return answer;
    }
    
    public int convertToTime(String time){
        String[] a = time.split(":");
        return Integer.valueOf(a[0])*60+Integer.valueOf(a[1]);
    }
}