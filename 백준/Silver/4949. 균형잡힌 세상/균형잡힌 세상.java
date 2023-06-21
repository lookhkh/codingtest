import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String next = "";
		
		while(!(next=br.readLine()).equals(".")){
			
			next = next.substring(0,next.length()-1).trim();
			if(next.length()==0) {
				bw.append("yes\n");
				continue;
			}else {
				
				Stack<Character> stack = new Stack<>();
				
				for(int i=0; i<next.length(); i++) {
					
					char n = next.charAt(i);
					if(n==']' || n=='[' || n==')' || n=='(') {
						
						if(n ==')' || n==']') {
							
							if(n==')' && !stack.isEmpty() && stack.peek()=='(') stack.pop();
							else if(n==']' && !stack.isEmpty() && stack.peek()=='[') stack.pop();
							else stack.push(n);
						}else {
							
							stack.push(n);
						}

					}
					
				}
				
				bw.append(stack.isEmpty()?"yes\n":"no\n");
				
			}
		}
		bw.flush();
	}
}