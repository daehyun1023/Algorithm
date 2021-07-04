import java.util.*;

class programmers카드짝맞추기 {

	class Pair {
		int x;
		int y;
		int d;

		Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	int[] dx = { -1, 0, 0, 1 };
	int[] dy = { 0, -1, 1, 0 };
	boolean[][] check;
	int[] numbers;
	int N = 0;
	Queue<Pair> q = new LinkedList();
	Pair[][] p;
	int[] repeatNumbers;
	int result = Integer.MAX_VALUE;
	int min = 0;
	
	
	//카드 bfs로 움직여주기
	public void bfs(int r, int c, int[][] board, int idx, int repeatIdx) {
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			if (curr.x == p[numbers[idx]][repeatIdx].x && curr.y == p[numbers[idx]][repeatIdx].y) {
				q.clear();
				min += curr.d;
				q.add(new Pair(curr.x, curr.y, 0));
				check = new boolean[4][4];
				check[curr.x][curr.y] = true;
				return;
			}
			
			// 상하좌우로 한칸씩, 컨트롤키 누르는 것도 같이
			for (int dir = 0; dir < 4; dir++) {
				int en = 0;
				while (true) {
					int nx = curr.x + dx[dir] * en;
					int ny = curr.y + dy[dir] * en;
					if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || (en != 0 && board[nx][ny] != 0))
						break;
					en++;
				}
				for (int i = 0; i < 2; i++) {
					int z = 1;
					if (i == 1)
						z = en;
					int nx = curr.x + dx[dir] * z;
					int ny = curr.y + dy[dir] * z;
					if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || check[nx][ny])
						continue;
					check[nx][ny] = true;
					q.add(new Pair(nx, ny, curr.d + 1));
				}
			}
		}
	}
	
	
	// 순열을 통해 짝이 주어지면 그 짝 중에서 어떤 애를 먼저 없앨지 선택해주기
	public void btr(int depth, int r, int c, int[][] board) {
		if (depth == N / 2) {
			min = 0;
			q.clear();
			q.add(new Pair(r, c, 0));
			check = new boolean[4][4];
			check[r][c] = true;
			for (int i = 0; i < N / 2; i++) {
				bfs(r, c, board, i, repeatNumbers[i]);
				bfs(r, c, board, i, (repeatNumbers[i] + 1) % 2);
			}
			System.out.println(min);
			result = Math.min(min, result);

			return;
		}

		for (int i = 0; i < 2; i++) {
			repeatNumbers[depth] = i;
			btr(depth + 1, r, c, board);
		}

	}
	
	
	// 순열을 통해 어떤 짝부터 없앨지 순서를 정해주기
	public void permutation(int depth, int mask, int r, int c, int[][] board) {
		if (depth == N / 2) {
			btr(0, r, c, board);
			return;
		}

		for (int i = 0; i < N / 2; i++) {
			if ((mask & (1 << i)) == 0) {
				numbers[depth] = i + 1;
				permutation(depth + 1, mask | 1 << i, r, c, board);
			}
		}
	}

	public int solution(int[][] board, int r, int c) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] != 0) {
					N++;
				}
			}
		}
		p = new Pair[10][2];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] != 0) {
					if (p[board[i][j]][0] != null) {
						p[board[i][j]][1] = new Pair(i, j, 0);
					} else {
						p[board[i][j]][0] = new Pair(i, j, 0);
					}
				}
			}
		}

		numbers = new int[N / 2];
		repeatNumbers = new int[N / 2];

		permutation(0, 0, r, c, board);

		return result + N;
	}

}
