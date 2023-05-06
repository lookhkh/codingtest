class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pp = Long.valueOf(p);
        for(int i=0; i+p.length()<t.length()+1; i++){
            
            String next = t.substring(i,i+p.length());
            long convertedNext = Long.valueOf(next);
            
            if(pp >= convertedNext) answer++;
            
        }
        
        return answer;
    }
}