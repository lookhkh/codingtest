
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int h;
	static int w;
	static int n;
	static List<int[]> list;
	
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		h = Integer.valueOf(tk.nextToken());
		w = Integer.valueOf(tk.nextToken());
		n = Integer.valueOf(br.readLine());
		
		list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			int r = Integer.valueOf(tk.nextToken());
			int c = Integer.valueOf(tk.nextToken());;
			
			if(checkIfIt(r,c)) list.add(new int[] {r,c});
		}
		
		int target = 2;
		int current = 0;
		int idx = 0;
		int[] indices = new int[2];
		combination(target, current, idx, indices);
		
		System.out.println(max);
	}

	private static void combination(int target, int current, int idx, int[] indices) {
		
		if(target == current) {
			
			
			int[] first = list.get(indices[0]);
			int[] second = list.get(indices[1]);
			
			
			for(int i=0; i<4; i++) {
				
				int firstX = 0;
				int firstY = 0;
				
				int secondX = 0;
				int secondY = 0;
				
				if(i == 0) {
					//그대로 
					firstX = first[0];
					firstY = first[1];
					
					secondX = second[0];
					secondY = second[1];
					
					if(!chkHW(firstX, firstY, secondX, secondY)) continue;
					else {
						max = Math.max(max, getResult(first, second));
						break;
					}	
				}
				
				if(i == 1) {
					//둘 다 바꿈
					firstX =  first[1];
					firstY = first[0];
					
					secondX = second[1];
					secondY = second[0];
					
					if(!chkHW(firstX, firstY, secondX, secondY)) continue;
					else {
						max = Math.max(max, getResult(new int[] {firstX,firstY}, new int[] {secondX, secondY}));
						break;
					}
				}
				
				if(i == 2) {
					//first만 바둠
					firstX =  first[1];
					firstY = first[0];
					
					secondX = second[0];
					secondY = second[1];
					
					if(!chkHW(firstX, firstY, secondX, secondY)) continue;
					else {
						max = Math.max(max, getResult(new int[] {firstX, firstY}, second));
						break;
					}
				}
				
				if(i == 3) {
					//second만 바꿈
					firstX =  first[0];
					firstY = first[1];
					
					secondX = second[1];
					secondY = second[0];
					
					if(!chkHW(firstX, firstY, secondX, secondY)) continue;
					else {
						max = Math.max(max, getResult(first, new int[] {secondX,secondY}));
						break;
					}
				}
				
			}
			
			
		}else {
			
			for(int i=idx; i<list.size(); i++) {
				indices[current] = i;
				combination(target, current+1, i+1, indices);
				
			}
			
		}
		
		
	}

	private static int getResult(int[] first, int[] second) {
		return first[0]*first[1]+second[0]*second[1];
	}
	
	static boolean chkHeight(int h1, int w1, int h2, int w2) {		
	if(h1+h2 > h || Math.max(w1, w2) > w) return false;
		else return true;
	}
	static boolean chkWidth(int h1, int w1, int h2, int w2) {	
		if(Math.max(h1, h2) > h || w1 + w2 >w) return false;
		else return true;
	}
	
	static boolean chkHW(int h1, int w1, int h2, int w2) {
		if(chkHeight(h1,w1,h2,w2)==true || chkWidth(h1,w1,h2,w2)==true) return true;
		else return false;
	}


	private static boolean checkIfIt(int r, int c) {

		if( r <=h && c <= w) return true;
		if( r <=w && c <= h) return true;
		
		return false;
	}
}
