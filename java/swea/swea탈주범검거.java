import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class swea탈주범검거 {
 
    static int N, M, R, C, L;
    static int[][] map;
    static int[] dr = {-1,0,0,1}; //상0,좌1,우2,하3
    static int[] dc = {0,-1,1,0};
    static String[] type = {
            null,
            "0312",
            "03",
            "12",
            "02",
            "32",
            "31",
            "01"   
    };
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
         
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //n행 m열의 크기
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken()); //맨홀 뚜껑 위치 R,C
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken()); //탈출 후 소요된 시간
            map = new int[N][M];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            System.out.println("#"+tc+" "+bfs());
        }
    }
    private static int bfs() {
        int result = 0, time = 1;
         
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[N][M];
         
        queue.offer(new int[] {R,C});
        visited[R][C] = true;
        ++result;
         
        while(time++<L) {
            int size = queue.size();
            while(size-->0) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                String info = type[map[r][c]];
                 
                for (int d = 0, length=info.length(); d < length; d++) {
                    int dir = info.charAt(d)-'0';
                    int nr = r+dr[dir];
                    int nc = c+dc[dir];
                    if(nr>=0 && nr<N && nc>=0 && nc<M
                            && map[nr][nc]>0
                            && type[map[nr][nc]].contains(Integer.toString(3-dir))
                            && !visited[nr][nc]) {
                        queue.offer(new int[] {nr,nc});
                        visited[nr][nc] = true;
                        ++result;
                    }
                }   
            }
        }
        return result;
    }
}