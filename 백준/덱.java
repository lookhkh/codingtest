//https://www.acmicpc.net/problem/10866

package b0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main10866 {

	static class Deque{
		
		LinkedList<Integer> arr;
		
		public Deque() {
			this.arr = new LinkedList<>();
		}
		
		public void command(String[] command) {
			if(command.length>1) {
				String cmd = command[0];
				int num = Integer.valueOf(command[1]);
				
				if(cmd.equals("push_back")) this.push_back(num);
				if(cmd.equals("push_front")) this.push_front(num);
				
					
			}else {
				
				String cmd = command[0];
				
				if(cmd.equals("front")) print(this.front());
				if(cmd.equals("back")) print(this.back());
				if(cmd.equals("empty")) print(this.empty());
				if(cmd.equals("size")) print(this.size());
				if(cmd.equals("pop_front")) this.print(this.pop_front());
				if(cmd.equals("pop_back")) this.print(this.pop_back());
				
			}
		}
		
		public void push_front(int n) {
			arr.addFirst(n);
		}
		
		public void push_back (int n) {
			arr.add(n);
		}
		
		public int pop_front() {
			if(this.arr.size() == 0) return -1;
			return arr.removeFirst();
		}
		
		public int pop_back() {
			if(this.arr.size() == 0) return -1;
			return arr.removeLast();
		}
		
		public int size() {
			return this.arr.size();
		}
		
		public int empty() {
			return this.arr.size()>0?0:1;
		}
		
		public int front() {
			if(this.arr.size() == 0) return -1;
			return this.arr.getFirst();
		}
		
		public int back() {
			if(this.arr.size() == 0) return -1;
			return this.arr.getLast();
		}
		
		private void print(int n) {
			System.out.println(n);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Deque que = new Deque();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			String[] tk = br.readLine().split(" ");
			que.command(tk);
		
			
		}
	}
}
