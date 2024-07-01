/**
주어진 항공권을 모두 이용
항상 ICN 에서 시작
가능한 경로가 2개 이상일 경우, 알파벳 순서가 앞서는 경로를 사용

**/
class Solution {
    String[][] tickets;
    String answer = null;
    String[] ans = null;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        this.tickets = tickets;
        boolean[] his = new boolean[tickets.length];
        for(int i=0; i<tickets.length; i++){
            
            String[] ticket = tickets[i];
            if(!ticket[0].equals("ICN")) continue;
            his[i] = true;
            String[] res = new String[this.tickets.length+1];
            res[0] = ticket[0];
            dfs(1, ticket, his, res);
            
            his[i] = false;
            
        }
        
        System.out.println(this.answer);
        
        String[] result = new String[this.tickets.length+1];
        int cnt = 0;
        for(int i=0; i<this.answer.length(); i+=3){
            result[cnt++] = this.answer.substring(i,i+3);    
        }
        
        return result;
    }
    
    void dfs(int cnt, String[] next, boolean[] his, String[] res){
        
        if(cnt == this.tickets.length){
            res[cnt] = next[1];
            StringBuilder b = new StringBuilder();
            for(String n : res){
                b.append(n);
            }
            String temp = b.toString();
            if(answer == null || answer.compareTo(temp) > 0){
                answer = b.toString();
                ans = res;
            }
        }else{
            
            for(int i=0; i<this.tickets.length; i++){
                String[] can = this.tickets[i];
                if(his[i] || !can[0].equals(next[1])) continue;
                his[i] = true;
                res[cnt] = next[1];
                dfs(cnt+1, can, his, res);
                his[i] = false;
            }
            
            
            
        }
        
    }
}