import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] temp = Arrays.stream(timetable)
            .mapToInt(w->convert(w))
            .sorted()
            .toArray();
                
        Deque<Integer> times = new LinkedList<>();
        
        for(int time : temp) times.add(time);

        int time = convert("09:00");
        
        for(int i=0; i<n-1; i++){
            int cur = 0;
            while(!times.isEmpty() && times.peek() <= time && cur < m){
                int ww = times.poll();
                cur++;
            }
            time += t;
        }
        
        // int lastTime = t > 1 ?  time +t: time;
        int lastTime = time;
        
        while(!times.isEmpty() && times.peek() > lastTime) times.poll();
    
        if(times.size()+1 <= m) return convert(lastTime);
        
        int curOne = lastTime;
        
        while(!times.isEmpty() && times.size()+1 > m){
            
            curOne = times.pollLast()-1;
            
        }
    
        
        return convert(curOne);
    }
    
    int convert(String m){
        
        String[] arr = m.split(":");
        int hour = Integer.valueOf(arr[0]) * 60;
        int min = Integer.valueOf(arr[1]);
        return hour + min;
        
    }
    
    String convert(int m){
        
        String hour = String.valueOf(m / 60);
        String min = String.valueOf(m % 60);
        if(hour.length()<2) hour = 0+hour;
        if(min.length()<2) min = 0+min;
        return hour+":"+min;
    }
}