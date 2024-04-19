class Solution {
    int[] table = new int[]{10,20,30,40};
    int maxUser = Integer.MIN_VALUE;
    int price = Integer.MIN_VALUE;
    public int[] solution(int[][] users, int[] emoticons) {
        
        dfs(0,new int[emoticons.length], users, emoticons);
        
        return new int[]{maxUser, price};
    }
    
    void dfs(int idx, int[] his, int[][] users, int[] emoticons){
        if(idx == his.length){
            int wholePrice = 0;
            int numOfUser = 0;
            for(int i=0; i<users.length; i++){
                int[] user = users[i];
                int sum = 0;
                for(int j=0; j<emoticons.length; j++){
                    if(his[j] >= user[0]) sum += (emoticons[j]/100) * (100-his[j]);
                }
                if(sum >= user[1]){
                    numOfUser+=1;
                }else{
                    wholePrice+=sum;
                }
            }
            
            if(this.maxUser < numOfUser ){
                this.maxUser = numOfUser;
                this.price = wholePrice;
            }else if(this.maxUser == numOfUser){
                this.price = Math.max(this.price, wholePrice);
            }

        }else{
            
            for(int i=0; i<table.length; i++){
                his[idx] = table[i];
                dfs(idx+1, his, users, emoticons);
            }
            
        }
    }
}