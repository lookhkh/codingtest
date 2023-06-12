import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int k;
	
	static int[][] arr;
	static int[] posOfK = new int[2];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringTokenizer tk = new StringTokenizer(in.nextLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		k = Integer.valueOf(tk.nextToken());
		arr = new int[n][m];
		
		if(k != 0) {
			findK();
		}
		
		if(k == 0) {
			
			long result = dfs(0,0,n-1,m-1, false);
			System.out.println(result);
		}else if(k != 0) {
			
			long result1 = dfs(0,0, posOfK[0], posOfK[1], false) ;
			long result2 = dfs(posOfK[0],posOfK[1], n-1,m-1, true);
			System.out.println(result1*result2);
		}
		
	}

	private static long dfs(int x, int y, int tarX, int tarY, boolean b) {
		if(x > n || y > m) return 0;
		if(k != 0 && !b) {
			if(x > posOfK[0] || y > posOfK[1]) return 0;
		}
		if(x == tarX && y == tarY) return 1;
		
		return dfs(x+1,y,tarX,tarY,b )+dfs(x,y+1,tarX,tarY,b);
	}

	private static void findK() {
		int cnt = 1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(cnt == k) {
					posOfK[0] = i;
					posOfK[1] = j;
					return;
				}else {
					cnt++;
				}
			}
		}
	}
}