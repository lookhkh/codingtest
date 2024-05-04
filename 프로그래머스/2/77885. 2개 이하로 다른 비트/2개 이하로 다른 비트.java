/**
1. 비트의 마지막이 0으로 끝나면, 1을 더해준다.
2. 비트에 0이 없으면, 맨 처음 글자를 10 으로 변경한다.
3. 비트의 마지막 0과, 그 다음 1일 바꿔준다.

**/
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            
            long next = numbers[i];
            String bin = Long.toBinaryString(next);
            if(bin.endsWith("0")) answer[i] = next+1;
            else{
                if(bin.indexOf("0") == -1) {
                    bin = "10"+bin.substring(1, bin.length());
                    System.out.println(bin);
                }else{
                    int idx = bin.lastIndexOf("0");
                    bin = bin.substring(0,idx)+"10"+bin.substring(idx+2, bin.length());
                }
                answer[i] = Long.parseLong(bin,2);
            }

        }
        
        
        return answer;
    }
}