/*
    자식에게서 이득이 발생하면, 부모에게 10%를 전달한다.
*/
import java.util.*;
class Solution {
    static class Member{
        
        Member parent;
        String name;
        int total;
        
        public Member(String name, int total){
            this.parent = null;
            this.name = name;
            this.total = total;
        }
        
        public void addParent(Member m){
            this.parent = m;
        }
        
        public void sell(int amount){

            int total = amount;
            if(this.parent == null){
                this.total += total;
            }

            if(this.parent != null){
                
                if(total / 10 == 0 ){
                    this.total += total;
                }else{
                     int remain = (total/10);
                     this.total += total - remain;
                     if(this.parent != null) this.parent.sell(remain);
                }
                // System.out.println(amount+" "+this);
            }
        }
        
        @Override
        public String toString(){
            return this.name+" "+this.total+" "+this.parent;
        }
        
    }
    Map<String, Member> status = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Member root = new Member("-",0);
        status.put("-",root);
        
        for(int i=0; i<enroll.length; i++){
            String name = enroll[i];
            Member m  = new Member(name,0);
            status.put(name, m);
            m.addParent(status.get(referral[i]));
        }
        
        
        for(int i=0; i<seller.length; i++){
            String sel = seller[i];
            int amt = amount[i];
            
            Member m = status.get(sel);
            m.sell(amt * 100);
            
        }
        
        for(int i=0; i<enroll.length; i++){
            answer[i] = status.get(enroll[i]).total;
        }
        
        return answer;
    }
}