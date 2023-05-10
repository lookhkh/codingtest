import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

	static List<Character> moum = Arrays.asList('a','e','i','o','u');
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String next;
		while(!(next = br.readLine()).equals("end")) {
			if(isAcceptable(next))sayAcceptable(next);
			else sayNotAcceptable(next);
		}
	}
	
	private static boolean isAcceptable(String next) {
		
		//최소 한 개의 모음을 포함해야 한다.
		//모음이 3개, 혹은 자음이 3개 연속으로 오면 안된다.
		//같은 글자가 연속으로 두 번은 허용되지 않는다. 다만 ee, oo는 허용한다.
		
		if(notIncludeMoum(next)) return false;
		if(includeSameCharInRow(next)) return false;
		if(includeMoreThanThreeMoumOrZaumInRow(next)) return false;
		
		return true;
	}

	private static boolean includeMoreThanThreeMoumOrZaumInRow(String next) {

		int isNow = -1;
		int cnt = 0;
		for(char t : next.toCharArray()) {
			
			int isWhat = moum.contains(t)? 0:1;
			if(isNow == -1) {
				isNow = isWhat;
				cnt++;
			}else {
				
				if(isWhat == isNow) cnt++;
				else {
					isNow = isWhat;
					cnt = 1;
				}

			}
			
			if(cnt >= 3) return true;
			
		}
		
		return false;
		
	}

	private static boolean includeSameCharInRow(String next) {
		char def = ' ';
		char prev = def;
		int cnt = 0;
		for(char t : next.toCharArray()) {
			
			if(prev == def) {
				prev = t;
				cnt ++;
			}
			else {
				
				if(t == prev) cnt++;
				else {
					prev = t;
					cnt = 1;
				}
			}
			if(cnt >= 2) {
				
				if(prev != 'e' && prev !='o') return true;
			}
			
		}
		
		return false;
	}

	private static boolean notIncludeMoum(String next) {

		boolean result = true;
		
		for(char t : next.toCharArray()) {
			if(moum.contains(t)) {
				result = false;
				break;
			}
		}
		
		return result;
	}

	public static void sayAcceptable(String str) {
		System.out.println("<"+str+">"+" is acceptable.");
	}
	public static void sayNotAcceptable(String str) {
		System.out.println("<"+str+">"+" is not acceptable.");
	}
}
