/*
    음악의 끝부분과 처음 부분이 이어진 경우도 존재.(순환고리 구조)
    부분적으로 맞다고 해도, 그게 정답이 아닐 수도 있다.
    제목, 재생 시작,종료 시간, 악보
    m < 1439개 이하
    C,D,F,G,A의 경우 #이 붙을 수 있음. 문자열 파싱 시 주의
    음악은 반드시 처음부터 재생.
    음악의 길이보다 길 경우, 처음부터 반속 재생한다.
    재생시간이 음악보다 짧은 경우, 재생시간만큼 재생된다. 
    음악이 00:00를 넘기는 경우는 없다.
    일치하는 음악이 여러개일 경우, 라디오 재생시간이 가장 긴 음악.
    그것마저 같을 경우에는, 먼저 입력된 음악 제목을 반환한다.
    
    CC#BCC#BC#BC#BC#B
    
*/
import java.lang.StringBuilder;
import java.util.*;

class Solution {    
    static class Music{
        int startTime;
        int endTime;
        int duration;
        String name;
        String compose;
        int idx;
        
        public Music(int idx, String info){
            String[] arr = info.split(",");
            this.startTime = parseTime(arr[0]);
            this.endTime = parseTime(arr[1]);
            this.duration = endTime - startTime;
            this.name = arr[2];
            this.compose = replace(arr[3]);
            this.idx = idx;
        }
        
        public String getFullMelody(){
            
            int time = 0;
            int idx = 0;
            StringBuilder b=  new StringBuilder();
            
            while(time < duration){
                time++;
                char next = this.compose.charAt(idx++);
                b.append(next);
               
                if(idx == this.compose.length()) idx=0;
            }
            
            return b.toString();
            
        }
        
        private int parseTime(String time){
            String[] t = time.split(":");
            return Integer.valueOf(t[0])*60
                    +Integer.valueOf(t[1]);
        }
    }
    public String solution(String m, String[] musicinfos) {
        
        m = replace(m);
        
        
        List<Music> tempR = new ArrayList<>();
        
        for(int i=0; i<musicinfos.length; i++){
            
            String musicinfo = musicinfos[i];
            
            Music music = new Music(i+1,musicinfo);
            
            String fullMellody = music.getFullMelody();
            
            if(fullMellody.contains(m)){
                
                    tempR.add(music);
                
                
            }
           
            
        
        }
        
        tempR.sort((t1,t2)->{
            if(t1.duration != t2.duration){
                return Integer.compare(t2.duration,t1.duration);
            }else{
                return Integer.compare(t1.idx,t2.idx);
            }
        });
        
        if(tempR.isEmpty()) return "(None)";
        
        return tempR.get(0).name;
    }
    
    public boolean doesEndWith(String m){
        return m.endsWith("C") || m.endsWith("D") || m.endsWith("F") || m.endsWith("G") || m.endsWith("A");
    }
    
    public static String replace(String m){
            
        m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("F#","f");
        m = m.replaceAll("A#","a");
        m = m.replaceAll("G#","g");

        return m;
    }
}