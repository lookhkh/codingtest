/*
    N명의 참가자는 1~N까지 번호를 배정받음.
    각 단계별로, 1-2, 3-4, 5-6 ... n-1 - n
    단계가 끝나면 다시, 1-n/2 로 번호
    최종 한 명이 남을 때까지 반복
*/
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int aa = a>b?b:a;
        int bb = a>b?a:b;
        System.out.println(aa+"  "+bb);

        while(aa!=bb){
            
           aa = getNextNumber(aa);
           bb = getNextNumber(bb);
           answer++;
        }
        
        return answer;
    }
    
    public int getNextNumber(int n){
        if(n % 2 == 0) return n/2;
        return n/2 + 1;
    }
}