import java.util.Scanner;

public class Main {
	
	static int n;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		
		if(n == 1) {
			System.out.println(1);
			return;
		}
		
		dfs(2,"1");
		
	}
	private static void dfs(int idx, String str) {
		
		if(idx == n+1) {
			System.out.println(str);
			System.exit(0);
		}else {
			
			
			for(char i='1'; i<='3'; i++) {
				
				if(checkIfLastWordsEqualsI(str,i)) continue;
				if(!checkIfValid(str+i)) continue;
				dfs(idx+1, str+i);
			}
			
		}
		
	}
	
	private static boolean checkIfValid(String str) {

		if(str.length() <= 3) return true;

		
		int length = str.length()/2;
		
		for(int i=2; i<=length; i++) {
			
			int idx = str.length()-i;
			String target = str.substring(idx);
			
			String pre = str.substring(idx-i,idx);
			
			
			if(target.equals(pre)) return false;
		}
		
		
		return true;
	}
	private static boolean checkIfEvenValid(String str) {
		
		if(str.length() == 1) return true;
		
		String first = str.substring(0,str.length()/2);
		String second = str.substring(str.length()/2);
		
		if(first.equals(second)) return false;
		
		
		return checkIfEvenValid(second);
	}
	private static boolean checkIfLastWordsEqualsI(String str, char cur) {

		return str.charAt(str.length()-1) == cur;
	}

}
