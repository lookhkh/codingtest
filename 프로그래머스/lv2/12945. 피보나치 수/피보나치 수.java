import java.util.ArrayList;
import java.util.List;

class Solution {
      public int solution(int n) {
        
        return noDfs(n);
    }
    
    
    public int noDfs(int n) {
    	List<Integer> list = new ArrayList<>();
    	list.add(0, 0);
    	if(n>0) {
    		list.add(1,1);
    		for(int i=2; i<=n; i++) {
    			list.add(i,(list.get(i-1)+list.get(i-2))%1234567); 
    		}
    	}
    	
    	
    	return list.get(list.size()-1);

    }
}