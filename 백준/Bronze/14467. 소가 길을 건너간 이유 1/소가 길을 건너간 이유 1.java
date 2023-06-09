import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[11];
		Arrays.fill(arr, -1);
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int num = Integer.valueOf(tk.nextToken());
			int pos = Integer.valueOf(tk.nextToken());
			
			if(arr[num] == -1) arr[num] = pos;
			else if(arr[num] != pos) {
				ans++;
				arr[num] = pos;
			}
			
		}
		System.out.println(ans);
	}
}