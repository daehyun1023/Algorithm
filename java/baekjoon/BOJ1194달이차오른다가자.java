import java.util.*;
import java.io.*;
public class BOJ1194달이차오른다가자 {

	static class Pair{
		int x, y, d, state;
		Pair(int x, int y, int d, int state){
			this.x=x;
			this.y=y;
			this.d=d;
			this.state = state;
		}
	}
	
	static int N, M, min = -1;
	static char[][] map;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static boolean[][][] visited;
	static Queue<Pair> q = new LinkedList<Pair>();
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(map[p.x][p.y] == '1') {
				min = p.d;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '#' || visited[nx][ny][p.state]) continue;
				if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					int nState = (p.state | (1<< map[nx][ny] - 'a'));
					if(!visited[nx][ny][nState]) {
						visited[nx][ny][nState] = true;
						q.offer(new Pair(nx, ny, p.d+1, nState));
					}
				}
				else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					if((p.state & (1 << map[nx][ny] - 'A')) > 0 && !visited[nx][ny][p.state]) {
						visited[nx][ny][p.state] = true;
						q.offer(new Pair(nx, ny, p.d+1, p.state));
					}
				}
				else {
					visited[nx][ny][p.state] = true;
					q.offer(new Pair(nx, ny, p.d+1, p.state));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][64];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					q.offer(new Pair(i, j, 0, 0));
					visited[i][j][0] = true;
				}
			}
		}
		
		bfs();
		
		System.out.println(min);
		
	}

}
