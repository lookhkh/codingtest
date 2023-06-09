
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		for(int i=0; i<n; i++) {
			String next = br.readLine();
			boolean result = checkIfValid(next);
			System.out.println(result?"YES":"NO");
		}
		
	}

	private static boolean checkIfValid(String next) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<next.length(); i++) {
			char nextChar = next.charAt(i);
			
			if(stack.isEmpty() && nextChar == ')') return false;
			if(!stack.isEmpty() && stack.peek() == '(' && nextChar ==')') stack.pop();
			else {
				stack.push(nextChar);
			}
			
		}
		
		return stack.size()==0?true:false;
	}
}