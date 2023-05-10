import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[] list;
	static boolean[] ch;
	static int firstIdx = 0;
	static int lastIdx = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		list = new int[n];
		ch = new boolean[n];
		lastIdx = ch.length-1;
		
		for(int i=0; i<n; i++) {
			int next = Integer.valueOf(tk.nextToken());
			list[i] = next;
		}

		int idx = 0;
		
		List<Integer> result = new ArrayList<>();
		
		while(result.size() <= n-1) {
			
			int next = list[idx];
			
			result.add(idx+1);
			
			ch[idx] = true;

			idx = getNextIdx(next, idx);
			
		}
		
		
		StringBuilder b= new StringBuilder();
		for(int i=0; i<result.size(); i++) {
			b.append(result.get(i)+" ");
		}
		
		System.out.println(b.toString().substring(0,b.length()-1));
		
	}

	private static int getNextIdx(int next, int idx) {

		
		for(int i=firstIdx; i<ch.length; i++) {
			if(!ch[i]) {
				firstIdx = i; 
				break;
			}
		}
		
		for(int i=lastIdx; i>=0; i--) {
			if(!ch[i]) {
				lastIdx = i; 
				break;
			}
		}
		
		
		if(firstIdx == lastIdx) return firstIdx;
		
		
		if(next < 0) {
			
			int cnt = Math.abs(next);
			
			for(int i=0; i<cnt; i++) {
				idx-=1;
				if(idx < firstIdx) idx = lastIdx;
				if(ch[idx]) i--;
			}
		}else {
			
			for(int i=0; i<next; i++) {
				idx+=1;
				if(idx > lastIdx) idx = firstIdx;
				if(ch[idx]) i--;
			}
			
		}

		
		return idx;
	}

}
