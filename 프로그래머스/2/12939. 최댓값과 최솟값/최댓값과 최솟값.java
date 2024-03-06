class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String next : arr){
            int t = Integer.parseInt(next);
            min = Integer.min(min, t);
            max = Integer.max(max, t);
        }
        
        
        
        return min+" "+max;
    }
}