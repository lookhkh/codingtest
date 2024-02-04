import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = convert(br.readLine());
		System.out.print(result);
	}

	private static String convert(String readLine) {
		
		StringBuilder b = new StringBuilder();
		
		Map<Character, Integer> priority = Map.of(
				'+', 1, 
				'-', 1, 
				'*', 2, 
				'/', 2, 
				'(', 3, 
				')', 3);
		
		Stack<Character> operator = new Stack<>();
		
		char[] chars = readLine.toCharArray();
		
		for(char next : chars) {
			
			if(next == '+' || next == '-' || next =='*' || next =='/' || next=='(' || next ==')') {
				
				if(operator.isEmpty()) operator.add(next);
				else {
					
					if(next ==')') {
						while(!operator.isEmpty()) {
							char top = operator.pop();
							if(top == '(') break;
							b.append(top);
						}
					}else {
											
						int curPriority = priority.get(next);
						
						while(!operator.isEmpty()) {
								
							int topPriority = priority.get(operator.peek());
							if(topPriority == 3) break;
							if(curPriority > topPriority) break;
							b.append(operator.pop());
							
						}
						
						operator.add(next);
					}
				}
				
			}else {
				b.append(next);
			}
			
		}
		
		while(!operator.isEmpty()) b.append(operator.pop());
		

		return b.toString();
	}


}