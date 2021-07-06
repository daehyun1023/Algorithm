package PrefixSum;
import java.util.*;
import java.io.*;
public class BOJ20440번 {
	
	static class Time implements Comparable<Time>{
		int start, end;
		public Time(int start, int end){
			this.start=start;
			this.end=end;
		}
		@Override
		public int compareTo(Time o) {
			int diff = this.start - o.start;
			return diff == 0 ? this.end - o.end : this.start - o.start;
		}
	}
	
	static int N;
	static Time[] time;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		time = new Time[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time[i] = new Time(start, end);
		}

		Arrays.sort(time);
		int s = time[0].start;
		int e = time[0].end;
		int cnt = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(e);
		
		for(int i=1; i<N; i++) {
			while(!pq.isEmpty() && pq.peek() < time[i].start) {
				pq.poll();
			}
			
			if(!pq.isEmpty() && pq.peek() == time[i].start) {
				if(pq.peek() == e) {
					e = time[i].end;
				}
				pq.poll();
			}
			
			pq.add(time[i].end);
			if(pq.size() > cnt) {
				cnt = pq.size();
				s = time[i].start;
				e = pq.peek();
			}
			
		}
		
		System.out.println(cnt);
		System.out.println(s + " " + e);
		
		

	}

}
