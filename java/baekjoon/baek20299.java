import java.util.*;

public class baek20299 {

	static int N;
	static int K;
	static int L;
	static int[][] team;
	static int result = 0;
	static ArrayList<int []> vips = new ArrayList();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		L = sc.nextInt();
		team = new int[N][3];
		for(int i=0;i <N;i++) {
			team[i][0] = sc.nextInt();
			team[i][1] = sc.nextInt();
			team[i][2] = sc.nextInt();
			if(team[i][0]<L) continue;
			if(team[i][1]<L) continue;
			if(team[i][2]<L) continue;
			if(team[i][0] +team[i][1] + team[i][2] < K) continue;
			result++;
			sb.append(team[i][0]+ " " + team[i][1] + " " + team[i][2]+" ");
		}
		
		System.out.println(result);
		System.out.println(sb);
	}

}
