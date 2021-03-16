import java.util.*;
import java.io.*;

public class swea1238Contact {

	static int N;
	static int start;
	static ArrayList<Integer>[] arr;
	static int[] check;
	static Queue<Integer> q;
	static int maxCnt;
	static int maxNum;

	public static void bfs() {
		while (!q.isEmpty()) {
			int x = q.poll();
			maxCnt = Math.max(maxCnt, check[x]);
			for(Integer i : arr[x]) {
				if(check[i] == -1) {
					check[i] = check[x] + 1;
					q.add(i);
				}
			}
			
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			System.out.println(start);
			check = new int[101];
			maxCnt = Integer.MIN_VALUE;
			maxNum = Integer.MIN_VALUE;
			arr = new ArrayList[101];
			for(int i=1; i<=100; i++) {
				arr[i] = new ArrayList();
			}
			q = new LinkedList();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(!arr[x].contains(y)) {
					arr[x].add(y);
				}
			}
			Arrays.fill(check, -1);
			check[start] = 0;
			q.add(start);
			bfs();
			System.out.println(arr[5]);
			System.out.println(Arrays.toString(check));
			System.out.println("#" + 1 + " " + maxCnt);
		}
			
	}

}
