import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Wrapper{
		int point;
		int teamCard;
		
		public Wrapper(int point, int teamCard) {

			this.point = point;
			this.teamCard = teamCard;
		}

		@Override
		public String toString() {
			return "Wrapper [point=" + point + ", teamCard=" + teamCard + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int k = Integer.valueOf(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine()," ");
		
		int[] shared = new int[n];
		
		for(int i=0; i<n; i++) {
			shared[i] = Integer.valueOf(tk.nextToken());
		}
		
		tk = new StringTokenizer(br.readLine()," ");
		
		int[] teams = new int[n];
		
		for(int i=0; i<n; i++) {
			teams[i] = Integer.valueOf(tk.nextToken());
		}
		
		PriorityQueue<Wrapper> que = new PriorityQueue<>((t1,t2)->Integer.compare(t2.point, t1.point));
		
		for(int i=0; i<shared.length; i++) {
			for(int j=0; j<teams.length; j++) {
				que.add(new Wrapper( shared[i] * teams[j], j ));
			}
		}
		
		
		boolean[] ch = new boolean[n];
		
		
		while(!que.isEmpty() && k > 0) {
			Wrapper next = que.poll();
//			System.out.println(next);
			
			int teamIdx = next.teamCard;
			
			if(ch[teamIdx]) continue;
			else {
				k--;
				ch[teamIdx] = true;
			}
			
		}
		
		while(!que.isEmpty()) {
			
			Wrapper next = que.poll();
			if(ch[next.teamCard]) continue;
			else {
				System.out.println(next.point);
				break;
			}
		}
		
		
		
	}
}