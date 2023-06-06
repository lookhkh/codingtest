import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static Set<String> set = new HashSet<>();
	static int max = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			String next = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = next.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				dfs(i,j,"");
			}
		}
		
		List<String> result = new ArrayList<>(set);
		
		for(int i=0; i<result.size(); i++) {
			int next = Integer.valueOf(result.get(i));
			while(next > 0) {
				double r = Math.sqrt(next);
				if(r % 1.0 == 0) {
					max = Math.max(max, next);
				}
				next /= 10;
			}
		
		}
		System.out.println(max);
				
	}
	private static void dfs(int x, int y, String sum) {

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i == 0&& j ==0) {
					sum += arr[x][y];
					set.add(sum);
					if(sum.equals("0")) max = 0;
					sum = "";
				}
				
				if(i != 0 || j != 0) {
					
					for(int z=0; z<4; z++) {
						
						if(z == 0) sum = execute(x, y, sum, i, j);
						if(z == 1) sum = execute(x, y, sum, i, j*-1);
						if(z == 2) sum = execute(x, y, sum, i*-1, j);
						if(z == 3) sum = execute(x, y, sum, i*-1, j*-1);
						set.add(sum);
						sum="";
					}
					
				}
				
				
				
			}
		}
		
	}
	private static String execute(int x, int y, String sum, int i, int j) {
		int ii = i;
		int jj = j;
		int nextX = x;
		int nextY = y;
		
		while((nextX>=0 && nextX<n && nextY>=0 && nextY<m)) {
			sum+=arr[nextX][nextY];
			nextX += ii;
			nextY += jj;
		}
		return sum;
	}
}