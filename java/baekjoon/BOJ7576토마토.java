import java.util.*;
import java.io.*;
public class BOJ7576토마토 {

	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int M, N, cnt, date;
	static int[][] arr, visited;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static Queue<Pair> q = new LinkedList();
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny] == 0 && arr[nx][ny] == 0) {
					visited[nx][ny] = visited[p.x][p.y] + 1;
					date = Math.max(date, visited[nx][ny]);
					cnt--;
					arr[nx][ny] = 1;
					q.add(new Pair(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					arr[i][j] = -1;
					q.offer(new Pair(i,j));
				}
				if(arr[i][j] == 0) {
					cnt++;
				}
			}
		}
		bfs();
		System.out.println(cnt == 0 ? date : -1);
		
	}

}
