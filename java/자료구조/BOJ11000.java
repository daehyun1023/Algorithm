package DataStructure;
import java.util.*;
import java.io.*;
public class BOJ11000 {

	static class Pair implements Comparable<Pair> {
		int start;
		int end;
		
		Pair(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Pair o) {
			int diff = this.start - o.start;
			return diff == 0 ? this.end - o.end : this.start - o.start;
		}
	}
	
	static int N, cnt = 1;
	static Pair[] times;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		times = new Pair[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			times[i] = new Pair(s, e);
		}
		
		Arrays.sort(times);
		int before = times[0].end;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(before);
		
		for(int i=1; i<N; i++) {
			if(pq.peek() <= times[i].start) {
				pq.poll();
				pq.add(times[i].end);
			}
			else {
				cnt++;
				pq.add(times[i].end);
			}
		}
		
		System.out.println(pq.size());
		
	}

}
