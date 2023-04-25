
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {


public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int num = Integer.parseInt(br.readLine());
	        List<Integer> arr= new ArrayList<>();
	        
	        for(int i=0; i<num; i++) {
	        	arr.add( Integer.valueOf(br.readLine()) );
	        }
	        
	        arr.sort(Comparator.reverseOrder());
	        
	        int answer = 0;
	        int cnt = 0;
	        
	        for(int i=0; i<arr.size(); i++) {
	        		
	        	int next = arr.get(i);
	        	
	        	answer += next;
	        	
	        	cnt++;
	        	
	        	if(cnt == 3) {
	        		cnt = 0;
	        		answer -= next;
	        	}
	        
	        }
	        
	        System.out.println(answer);
	        
	}
}
