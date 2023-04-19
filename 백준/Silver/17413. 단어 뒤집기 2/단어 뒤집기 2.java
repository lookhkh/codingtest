import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		
		StringBuilder ans = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		boolean isClosed = false;
		for(int i=0; i<t.length(); i++) {
			
			char next = t.charAt(i);
			
			if(next =='<' ) {
				
				isClosed = true;
				ans.append(temp.reverse().toString());
				ans.append(next);
				
				temp = new StringBuilder();
			}else if(next =='>') {
				
				ans.append(next);
				isClosed = false;
			}else {
				
				if(isClosed) ans.append(next);
				else {
					
					if(next == ' ') {
						
						ans.append(temp.reverse().toString());
						ans.append(next);
						temp = new StringBuilder();
					}else {
						temp.append(next);
					}
					
					
				}
				
				
			}
		}
		
		if(temp.length()>0) {
			ans.append(temp.reverse().toString());
		}
		
		

		
		System.out.println(ans.toString());
	}
	
}
