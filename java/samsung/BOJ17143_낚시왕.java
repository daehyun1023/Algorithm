package samsung;

import java.util.*;
import java.io.*;

public class BOJ17143_낚시왕 {

	static int R, C, M, sum;
	static Shark[][] map;
	static ArrayList<Shark> list = new ArrayList<Shark>();

	// 상, 하, 우, 좌
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Shark[R + 1][C + 1]; // 0 dummy

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); // 속도
			int d = Integer.parseInt(st.nextToken()); // 방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			Shark shark = new Shark(i + 1, r, c, s, d - 1, z);
			list.add(shark);
			map[r][c] = shark;
		}

		// 시뮬레이션
		for (int i = 1; i <= C; i++) {
			catchShark(i);
			moveShark();
			arrangeShark();
		}

		// sum 출력
		System.out.println(sum);
	}

	static void arrangeShark() {
		map = new Shark[R + 1][C + 1];
		int size = list.size();
		for (int i = size - 1; i >= 0; i--) { // remove() 의한 index 오류 해결
			Shark s = list.get(i);
			if (map[s.r][s.c] == null) {
				map[s.r][s.c] = s;
			} else {
				// 같은 위치 상어 처리
				if (s.z > map[s.r][s.c].z) {
					list.remove(map[s.r][s.c]); // 기존 상어 삭제
					map[s.r][s.c] = s; // 현재 상어 추가
				} else {
					list.remove(s);
				}
			}
		}
	}

	static void moveShark() {
		for (Shark shark : list) {
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;

			switch (d) {
			case 0:
			case 1:
				s = s % (R * 2 - 2); // 5칸 기준 8칸 이동하면 제자리
				for (int i = 0; i < s; i++) {
					if (r == 1)
						d = 1;
					else if (r == R)
						d = 0;
					r += dy[d];
				}
				shark.r = r;
				shark.d = d;
				break;

			case 2: // 좌우
			case 3:
				s = s % (C * 2 - 2); // 5칸 기준 8칸 이동하면 제자리
				for (int i = 0; i < s; i++) {
					if (c == 1)
						d = 2;
					else if (c == C)
						d = 3;
					c += dx[d];
				}
				shark.c = c;
				shark.d = d;
				break;
			}
		}
	}

	static void catchShark(int col) {
		for (int i = 1; i <= R; i++) {
			if (map[i][col] != null) {
				// 점수
				sum += map[i][col].z;
				list.remove(map[i][col]);
				break;
			}
		}
	}

	static class Shark {
		int n, r, c, s, d, z;

		public Shark(int n, int r, int c, int s, int d, int z) {
			this.n = n;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}
