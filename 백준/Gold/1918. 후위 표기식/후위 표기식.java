import java.util.Scanner;
import java.util.Stack;

public class Main {
		
	private static int getPriority(char target) {
		
		if(target == '+' || target =='-') return 0;
		else if(target == '*' || target == '/') return 1;
		else return -1;
		
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		StringBuilder b= new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		
		String str = in.nextLine();
		
		
		for(int i=0; i<str.length(); i++) {
			
			char next = str.charAt(i);
			
			if(next >='A' && next <='Z') b.append(next);
			else {
				
				if(stack.isEmpty()) stack.push(next);
				else {
					
					char atTop = stack.peek();
					
					if(next==')') {
						
						while(!stack.isEmpty() && stack.peek()!='(') {
							b.append(stack.pop());
						}
						
						if(!stack.isEmpty() && stack.peek()=='(') stack.pop(); 
						continue;
					}
					
					if(next=='(') {
						stack.push(next);
						continue;
					}
					
					if(getPriority(atTop) >= getPriority(next)) {
						
						while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(next)) {
							b.append(stack.pop());								
						}
						
						stack.push(next);

						
					}
					
					else {
						stack.push(next);
					}
					
				}
				
				
			}
			
		}
		
		while(!stack.isEmpty()) b.append(stack.pop());
		System.out.println(b.toString());
	}
	

  }