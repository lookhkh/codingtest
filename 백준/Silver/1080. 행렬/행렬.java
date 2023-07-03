
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		int[][] arr1 = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String next = br.readLine();
			for(int j=0; j<next.length(); j++) {
				arr1[i][j] = Integer.valueOf(next.charAt(j)-'0');
			}
		}
		
		int[][] arr2 = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String next = br.readLine();
			for(int j=0; j<next.length(); j++) {
				arr2[i][j] = Integer.valueOf(next.charAt(j)-'0');
			}
		}
		
		int ans = 0;
		for(int i=0; i<n-2; i++) {
			for(int j=0; j<m-2; j++) {
				if(arr1[i][j]==arr2[i][j]) continue;
				flip(i,j,arr1);
				ans++;
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				if(arr1[i][j] != arr2[i][j]) {
					System.out.println(-1);
					return;
				}
				
			}
		}
		
		System.out.println(ans);
	}

	private static void flip(int i, int j, int[][] arr1) {
		
		for(int x=i; x<=i+2; x++) {
			for(int y=j; y<=j+2; y++) {
				arr1[x][y] = arr1[x][y] == 1? 0: 1;
			}
		}
		
	}
}
