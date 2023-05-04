import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int[] arr = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		String oper = br.readLine();
		
		for(int i=0; i<n; i++) {
			
			int t = Integer.valueOf(br.readLine());
			arr[i] = t;
			
		}
		
		Stack<Double> stack = new Stack<>();
		
		char[] opers = oper.toCharArray();
		
		for(char op : opers) {
			
			if('A'<=op && op<='Z') {
				stack.push((double)arr[op-'A']);
			}else {
				double second = stack.pop();
				double first = stack.pop();
				
				double result = getResult(first, second, op);
				stack.push(result);
			}
			
		}
		
		System.out.printf("%.2f", stack.pop());
		

	}
	private static double getResult(double first, double second, char op) {
		
		if(op == '+') return first + second;
		if(op == '-') return first - second;
		if(op == '*') return first * second;
		
		return first / second;
	}
}
