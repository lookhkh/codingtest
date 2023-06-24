class Solution {
    public String solution(int[] food) {

        StringBuilder n = new StringBuilder();
        
        for(int i=1; i<food.length; i++){
            
            int next = food[i];
            if(next % 2 != 0) next-=1;
            if(next <= 0) continue;
            for(int j=0; j<next/2; j++){
                n.append(i);
            }
            
        }
        String right = new StringBuilder(n).reverse().toString();
        n.append(0);
        
        
        return n.toString()+right;
    }
}