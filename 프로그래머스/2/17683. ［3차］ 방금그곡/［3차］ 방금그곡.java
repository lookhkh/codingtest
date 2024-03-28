import java.util.LinkedHashMap;
import java.util.Map;
class Solution {
  public String solution(String m, String[] musicinfos) {
      String transformedM = transformSharp(m);

        String[][] parsedMusiinfos = new String[musicinfos.length][4];
        for(int i = 0; i < musicinfos.length; i++) {
            String[] tmp = musicinfos[i].split(",");
            for(int j = 0; j < 4; j++) {
                parsedMusiinfos[i][j] = tmp[j];
            }
        }

        String[] transformedMusic = new String[musicinfos.length];
        for(int i = 0; i < transformedMusic.length; i++) {
            transformedMusic[i] = transformSharp(parsedMusiinfos[i][3]);
        }

        Map<String, MusicInfo> playedMusics = new LinkedHashMap<>();

        for(int i = 0; i < parsedMusiinfos.length; i++) {
            int time = betweenTime(parsedMusiinfos[i][0], parsedMusiinfos[i][1]);
            StringBuilder playedMusic = new StringBuilder();
            if(time <= transformedMusic[i].length()) {
                playedMusic.append(transformedMusic[i].substring(0, time));
            }else {
                for(int j = 0; j < time / transformedMusic[i].length(); j++) {
                    playedMusic.append(transformedMusic[i]);
                }
                playedMusic.append(transformedMusic[i].substring(0, time % transformedMusic[i].length()));
            }
            playedMusics.put(playedMusic.toString(), new MusicInfo(parsedMusiinfos[i][2], time));
        }
        int longestPlayedTime = 0;
        String answer = "(None)";
        for(String key : playedMusics.keySet()) {
            if(key.contains(transformedM)) {
                int playedTime = playedMusics.get(key).playedTime;
                if(longestPlayedTime < playedTime) {
                    longestPlayedTime = playedTime;
                    answer = playedMusics.get(key).musicName;
                }
            }
        }
        return answer;
  }
    int betweenTime(String start, String end) {
        String[] splitedStart = start.split(":");
        String[] splitedEnd = end.split(":");
        return (Integer.parseInt(splitedEnd[0]) * 60 + Integer.parseInt(splitedEnd[1])) - (Integer.parseInt(splitedStart[0]) * 60 + Integer.parseInt(splitedStart[1]));
    }
    String transformSharp(String m) {
        StringBuilder sb = new StringBuilder();
        char current, next;
        int length = m.length();
        for(int i = 0; i < length - 1; i++) {
            current = m.charAt(i);
            next = m.charAt(i + 1);
            if(next == '#') {
                sb.append((char)(current + 32));
                i++;
            }else {
                sb.append(current);
            }
        }
        char last = m.charAt(length - 1);
        if(last != '#') {
            sb.append(last);
        }
        return sb.toString();
    }
}
class MusicInfo {
        String musicName;
        int playedTime;
        public MusicInfo(String musicName, int playedTime) {
            this.musicName = musicName;
            this.playedTime = playedTime;
        }
}
