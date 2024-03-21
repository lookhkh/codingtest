class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        a-=1;
        b-=1;
        while(true){
            
            int aGroup = a/2;
            int bGroup = b/2;
            if(aGroup == bGroup) return answer;
            a = a/2;
            b = b/2;
            
            answer++;
            
        }
    }
}