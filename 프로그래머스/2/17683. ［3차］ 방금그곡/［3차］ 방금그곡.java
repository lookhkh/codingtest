class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = replace(m);
        int maxTime = -1;
        
        for(String next : musicinfos){
            String[] arr = next.split(",");
            int duration = getDuration(arr[0],arr[1]);
            String info = replace(arr[3]);
            StringBuilder b = new StringBuilder();
            
            while(info.length() < duration){
                info += info;
            }
            
            info = info.substring(0, duration);
            
            if(info.contains(m) && maxTime < duration){
                maxTime = duration;
                answer = arr[2];
            }
            
            
        }
        
        return answer;
    }
    
    int getDuration(String start, String end){
        return getDuration(end) - getDuration(start);
    }
    
    int getDuration(String time){
        return Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
    }
    
    String replace(String m){
    return m
        .replaceAll("C#","c")
        .replaceAll("D#","d")
        .replaceAll("F#","f")
        .replaceAll("G#","g")
        .replaceAll("A#","a")
        .replaceAll("B#","b");
    }
}