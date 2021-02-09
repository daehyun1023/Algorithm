import java.util.*;
public class baek1158 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList();
		int cnt = 0;
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] result = new int[N];
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		int idx = 0;
		
		while(!q.isEmpty()) {
			cnt++;
			int person = q.poll();
			if(cnt!=K) {
				q.add(person);
				continue;
			}
			cnt = 0;
			result[idx] = person;
			idx++;
			
		}
		
		System.out.print("<");
		for(int i=0;i<N-1;i++) {
			System.out.print(result[i]+", ");
		}
		System.out.println(result[N-1]+">");
	}

}
