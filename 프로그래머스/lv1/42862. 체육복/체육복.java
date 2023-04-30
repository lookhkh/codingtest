import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    
    static Map<Integer,Integer> reserveStatus = new HashMap<>();

   
         public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        for(int i=0; i<reserve.length; i++) {
            
            int reserveOwner = reserve[i];
            reserveStatus.put(reserveOwner, 1);
            
        }
        
        Arrays.sort(lost);

        
        for(int i=0; i<lost.length; i++) {
            int lostStudent = lost[i];

            if(isStudentHavingReserve(lostStudent,reserve)) {
                answer++;
                lost[i] = -1;
            }
        }
        
        
        
        for(int i=0; i<lost.length; i++) {
            
            int lostStudent = lost[i];
                
            if(lostStudent == -1) continue;

                if(lostStudent>1) {
                    
                    int previousStudent = lostStudent-1;
                    if(isStudentHavingReserve(previousStudent, reserve)) {
                        answer++;
                        continue;
                    }
                
                }
                
                if(lostStudent<n) {
                    
                    int laterStudent = lostStudent+1;
                    if(isStudentHavingReserve(laterStudent, reserve)) {
                        answer++;
                        continue;
                    }
                    
                }
                
            }
            
            
        

        
        return answer;
    }

    private boolean isStudentHavingReserve(int student, int[] reserve) {
        
        if(reserveStatus.containsKey(student) && 
           reserveStatus.get(student) == 1) {
            reserveStatus.put(student, 0);
            return true;
        }
        
        return false;
    }


}
