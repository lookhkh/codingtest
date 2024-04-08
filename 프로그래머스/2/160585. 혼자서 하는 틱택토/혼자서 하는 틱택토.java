/**
1. o가 빙고일 경우, x는 o보다 항상 1개 적으며, x의 빙고가 있어서는 안된다.
2. x가 빙고일 경우, o는 x와 돌이 똑같이 있으나, o의 빙고가 있어서는 안된다.
3. o,x 둘 다 빙고가 없는 경우, o는 항상 x보다 돌이 많거나 같다.
**/
class Solution {
    public int solution(String[] board) {
        int numsOfO = getNum(board, 'O');
        int numsOfX = getNum(board, 'X');
        int nusOfOBingo = getBingo(board, 'O');
        int numsOfXBingo = getBingo(board, 'X');

        // x는 o보다 항상 같거나 한 개 적어야 한다.
        if(numsOfO - numsOfX < 0) return 0;
        else if(numsOfO == numsOfX){
            //둘 다 빙고가 없거나, o는 빙고가 없고, x는 빙고가 하나여야 한다.
            if(nusOfOBingo ==0 && numsOfXBingo == 0) return 1;
            if(nusOfOBingo > 0) return 0;
            if(numsOfXBingo > 1) return 0;
        }else{
            if(numsOfO - numsOfX > 1) return 0;
            if(numsOfXBingo > 0) return 0;
        }
        
        return 1;
    }
    
    int getNum(String[] board, char target){
        int sum = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i].charAt(j) == target) sum++;
            }
        }
        
        return sum;
    }
    
    int getBingo(String[] board, char target){
        int sum = 0;
        sum += getHorizon(board, target);
        sum += getVertical(board, target);
        sum += getDaegaksun(board, target);
        return sum;
    }
    
    int getHorizon(String[] board, char target){
        int sum = 0;
        for(int i=0; i<3; i++){
            int temp = 0;
            for(int j=0; j<3; j++){
                if(board[i].charAt(j) == target) temp++;
            }
            if(temp == 3) sum++;
        }
        
        return sum;
    }
    
    int getVertical(String[] board, char target){
        int sum =0;
        for(int i=0; i<3; i++){
            int temp = 0;
            for(int j=0; j<3; j++){
                if(board[j].charAt(i) == target) temp++;
            }
            if(temp == 3) sum++;
        }
        
        return sum;
    }
    
    int getDaegaksun(String[] board, char target){
        
        int sum = 0;
        for(int i=0; i<2; i++){
            int temp = 0;
            if(i == 0){
                for(int x=0; x<3; x++){
                    if(target == board[x].charAt(x)) temp++;
                }
            }else{
                for(int x=0; x<3; x++){
                    if(target == board[x].charAt(2-x)) temp++;
                }
            }
            if(temp == 3) sum++;
        }
        
        return sum;
        
    }
}